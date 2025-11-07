package hotel.models;

import hotel.interfaces.IInspectable;

public class Client implements IInspectable {
    private final String fullname;
    private Room room;

    public Client(String fullname) { this.fullname = fullname; };

    public String GetFullname() { return this.fullname; };
    public Room GetRoom() { return this.room; };

    public void SetRoom(Room room) { this.room = room; };

    public void Inspect() {
        String room = this.room == null ? "null" : String.valueOf(this.room.GetNumber());
        System.out.printf("<Client#%s room: %s>\n", this.fullname, room);
    }
}