package hotel.controllers;

import hotel.enums.RoomStatus;
import hotel.models.Client;
import hotel.models.Room;
import hotel.services.HotelService;
import hotel.views.RoomView;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomController {
    private final RoomView view = new RoomView();

    public void index() {
        ArrayList<Room> rooms = HotelService.get().getRoomService().getRooms().get();
        view.index(rooms);
    }

    public void show(int number) {
        Room room = HotelService.get().getRoomService().getRoom(number);
        view.show(room);
    }

    public void create(int number, int capacity, int stars, float price) {
        Room room = new Room(number, capacity, stars);
        room.setPrice(price);
        HotelService.get().getRoomService().addRoom(room);
        this.index();
    }

    public void update(int number, RoomStatus status, Integer stars, Float price) {
        Room room = HotelService.get().getRoomService().getRoom(number);
        HotelService.get().getRoomService().changeStatusOf(number, status);
        if (price != null) { room.setPrice(price); }
        if (stars != null) { room.setStars(stars); }
        view.show(room);
    }

    public void destroy(int number) {
        HotelService.get().getRoomService().destroyRoom(number);
        this.index();
    }

    public void evict(int number) {
        HotelService.get().getRoomService().evictFrom(number);
        Room room = HotelService.get().getRoomService().getRoom(number);
        view.show(room);
    }

    public void populate(int number, String clientName) {
        LocalDate evictionDate = LocalDate.now().plusWeeks(1);
        Client client = HotelService.get().getClientService().getClient(clientName);
        Room room = HotelService.get().getRoomService().getRoom(number);
        HotelService.get().getRoomService().populateTo(number, client, evictionDate);
        view.show(room);
    }
}