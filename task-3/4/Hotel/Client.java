package Hotel;

public class Client {
    private String fullname;
    private Room room;

    public Client(String fullname) { this.fullname = fullname; };

    public String GetFullname() { return this.fullname; };
    public Room GetRoom() { return this.room; };

    public void ChangeRoom(Room room) { this.room = room; };
}