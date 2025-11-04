package hotel.services;

import hotel.collections.RoomsCollection;
import hotel.models.Room;
import hotel.models.Client;
import hotel.enums.RoomStatus;
import java.time.LocalDate;

public class RoomService {
    private final RoomsCollection rooms = new RoomsCollection();

    public RoomsCollection GetRooms() { return this.rooms; }

    public Room GetRoom(int roomNumber) {
        Room foundRoom = null;
        for ( Room room : this.rooms.Get() ) {
            if (room.GetNumber() == roomNumber) { return foundRoom = room; }
        }
        return foundRoom;
    }

    public void AddRoom(Room room) { this.rooms.Get().add(room); };

    public void ChangeStatusOf(int roomNumber, RoomStatus newStatus) {
        Room room = this.GetRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        room.SetStatus(newStatus);
        System.out.printf("Room %d status set to %s\n", room.GetNumber(), room.GetStatus() );
    };

    public void EvictFrom(int roomNumber) {
        Room room = this.GetRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        Client client = room.GetClient();
        if (client == null) {
            System.out.printf("Client in room %d not exists\n", roomNumber);
            return;
        };

        room.SetClient(null);
        room.GetLastClients().Get().add(client);
        client.SetRoom(null);
        System.out.printf("Client %s is evicted from room %d\n", client.GetFullname(), room.GetNumber());
    };

    public void PopulateTo(int roomNumber, Client client, LocalDate evictionDate) {
        Room room = this.GetRoom(roomNumber);
        if (room == null) {
            System.out.printf("Room with %d not found\n", roomNumber);
            return;
        }

        room.SetClient(client);
        room.SetEvictionDate(evictionDate);
        client.SetRoom(room);
        System.out.printf("Client %s is populated to room %d\n", client.GetFullname(), room.GetNumber());
    };
}
