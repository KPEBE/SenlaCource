package Hotel;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Service> services = new ArrayList<Service>();

    public ArrayList<Room> GetRooms() { return new ArrayList<Room>(this.rooms); };
    public Room GetRoom(int roomNumber) {
        Room foundRoom = null;
        for ( Room room : this.rooms ) {
            if (room.GetNumber() == roomNumber) { return foundRoom = room; }
        }
        return foundRoom;
    }

    public ArrayList<Service> GetServices() { return new ArrayList<Service>(this.services); };

    public void AddRoom(Room room) { this.rooms.add(room); };
    public void AddService(Service service) { this.services.add(service); };
}