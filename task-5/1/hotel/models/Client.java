package hotel.models;

import hotel.exceptions.client.CreateClientException;
import hotel.interfaces.IInspectable;
import hotel.services.HotelService;

public class Client extends Model implements IInspectable {
    private String fullname;
    private Room room;

    public Client(Integer id) { super(id); };
    public Client(String fullname) { 
        super(null);
        if (HotelService.get().hotel.clientService.getClients().findByFullname(fullname) != null) { throw new CreateClientException("duplicate client name"); }

        this.fullname = fullname;
    };

    public String getFullname() { return this.fullname; };
    public Room getRoom() { return this.room; };

    public void setRoom(Room room) { this.room = room; };
    public void setFullname(String newName) { this.fullname = newName; };

    @Override
    public String toString() {
        String roomString = this.room == null ? "null" : String.valueOf(this.room.getID());
        return String.format("<Client#%s name: %s room: %s>", this.getID(), this.fullname, roomString);
    }
}