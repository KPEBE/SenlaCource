package hotel.services;

import hotel.collections.RoomsCollection;
import hotel.enums.RoomStatus;
import hotel.models.Client;
import hotel.models.Room;
import java.time.LocalDate;

public class RoomService {
    private final RoomsCollection rooms = new RoomsCollection();

    public RoomsCollection getRooms() { return this.rooms; }

    public Room getRoom(int roomNumber) {
        Room foundRoom = null;
        for ( Room room : this.rooms.get() ) {
            if (room.getNumber() == roomNumber) { foundRoom = room; }
        }
        return foundRoom;
    }

    public void addRoom(Room room) { this.rooms.get().add(room); };

    public void destroyRoom(int roomNumber) {
        Room room = getRoom(roomNumber);
        if (room == null) return;

        evictFrom(roomNumber);
        this.rooms.get().remove(room);
    };

    public void changeStatusOf(int roomNumber, RoomStatus newStatus) {
        Room room = this.getRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        room.setStatus(newStatus);
        System.out.printf("Room %d status set to %s\n", room.getNumber(), room.getStatus() );
    };

    public void evictFrom(int roomNumber) {
        Room room = this.getRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        Client client = room.getClient();
        if (client == null) {
            System.out.printf("Client in room %d not exists\n", roomNumber);
            return;
        }

        room.setClient(null);
        room.getLastClients().get().add(client);
        client.setRoom(null);
        System.out.printf("Client %s is evicted from room %d\n", client.getFullname(), room.getNumber());
    };

    public void populateTo(int roomNumber, Client client, LocalDate evictionDate) {
        Room room = this.getRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        room.setClient(client);
        room.setEvictionDate(evictionDate);
        client.setRoom(room);
        System.out.printf("Client %s is populated to room %d\n", client.getFullname(), room.getNumber());
    };
}
