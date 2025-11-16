package hotel.controllers;

import hotel.enums.RoomStatus;
import hotel.models.Client;
import hotel.models.Room;
import hotel.services.HotelService;
import hotel.services.RoomService;
import hotel.views.RoomView;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomController {
    private final RoomView view = new RoomView();
    private final RoomService service = HotelService.get().getRoomService();

    public void index() {
        ArrayList<Room> rooms = service.getRooms().get();
        view.index(rooms);
    }

    public void show(int id) {
        Room room = service.getRoom(id);
        view.show(room);
    }

    public void create(int number, int capacity, int stars, float price) {
        Room room = new Room(number, capacity, stars);
        room.setPrice(price);
        service.addRoom(room);
        this.index();
    }

    public void update(int id, RoomStatus status, Integer stars, Float price) {
        Room room = service.getRoom(id);
        service.changeStatusOf(id, status);
        if (price != null) { room.setPrice(price); }
        if (stars != null) { room.setStars(stars); }
        view.show(room);
    }

    public void destroy(int id) {
        service.destroyRoom(id);
        this.index();
    }

    public void evict(int id) {
        service.evictFrom(id);
        Room room = service.getRoom(id);
        view.show(room);
    }

    public void populate(int id, int clientId) {
        LocalDate evictionDate = LocalDate.now().plusWeeks(1);
        Client client = HotelService.get().getClientService().getClient(clientId);
        Room room = service.getRoom(id);
        service.populateTo(id, client, evictionDate);
        view.show(room);
    }

    public void saveRoom(Integer id) {
        Room room = service.getRoom(id);
        this.service.saveRoom(id);
        view.show(room);
    };

    public void saveRooms() { this.service.saveRooms(); this.index(); };
    public void loadRooms() { this.service.loadRooms(); this.index(); };
}