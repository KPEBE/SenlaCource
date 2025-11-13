package hotel.models;

import hotel.interfaces.IInspectable;

public class Client implements IInspectable {
    private String fullname;
    private Room room;

    public Client(String fullname) { this.fullname = fullname; };

    public String getFullname() { return this.fullname; };
    public Room getRoom() { return this.room; };

    public void setRoom(Room room) { this.room = room; };
    public void setFullname(String newName) { this.fullname = newName; };

    @Override
    public String toString() {
        String roomString = this.room == null ? "null" : String.valueOf(this.room.getNumber());
        return String.format("<Client#%s room: %s>", this.fullname, roomString);
    }
}