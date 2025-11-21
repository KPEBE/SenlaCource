package hotel.services;

import hotel.collections.RoomsCollection;
import hotel.enums.RoomStatus;
import hotel.models.Client;
import hotel.models.Room;
import hotel.storages.RoomsStorage;
import java.time.LocalDate;

public class RoomService {
    private final RoomsCollection rooms = new RoomsCollection();
    private final RoomsStorage storage = new RoomsStorage(this);

    public RoomsCollection getRooms() { return this.rooms; }

    public Room getRoom(Integer id) { return rooms.find(id); }

    public void addRoom(Room room) { this.rooms.get().add(room); };

    public void destroyRoom(Integer id) {
        Room room = getRoom(id);
        if (room == null) return;

        evictFrom(id);
        this.rooms.get().remove(room);
    };

    public void changeStatusOf(Integer id, RoomStatus newStatus) {
        Room room = this.getRoom(id);
        if (room == null) {
            System.out.printf("Room with %d not found\n", id);
            return;
        }

        room.setStatus(newStatus);
        System.out.printf("Room %d status set to %s\n", room.getNumber(), room.getStatus() );
    };

    public void evictFrom(Integer id) {
        Room room = this.getRoom(id);
        if (room == null) {
            System.out.printf("Room with %d not found\n", id);
            return;
        }

        Client client = room.getClient();
        if (client == null) {
            System.out.printf("Client in room %d not exists\n", id);
            return;
        }

        room.setClient(null);
        room.getLastClients().get().add(client);
        client.setRoom(null);
        System.out.printf("Client %s is evicted from room %d\n", client.getFullname(), room.getNumber());
    };

    public void populateTo(Integer id, Client client, LocalDate evictionDate) {
        if (client == null) {
            System.out.println("Client not present");
            return;
        }

        Room room = this.getRoom(id);
        if (room == null) {
            System.out.printf("Room with %d not found\n", id);
            return;
        }

        room.setClient(client);
        room.setEvictionDate(evictionDate);
        client.setRoom(room);
        System.out.printf("Client %s is populated to room %d\n", client.getFullname(), room.getNumber());
    };

    public void saveRoom(Integer id) { this.storage.saveRoom(getRoom(id)); };
    public void saveRooms() { this.storage.saveRooms(); };
    public void loadRooms() { this.storage.loadRooms(); };
}
