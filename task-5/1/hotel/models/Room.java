package hotel.models;

import hotel.collections.ClientsCollection;
import hotel.config.Config;
import hotel.enums.RoomStatus;
import hotel.exceptions.room.*;
import hotel.interfaces.IInspectable;
import hotel.services.HotelService;
import java.time.LocalDate;

public class Room extends Model implements IInspectable {
    private int number;
    private int capacity;
    private int stars;
    private LocalDate evictionDate;
    private RoomStatus status;
    private Client client;
    private final ClientsCollection lastClients = new ClientsCollection();
    private float price = 0.0f;

    public Room(Integer id) { super(id); }
    public Room(int number, int capacity, int stars) throws CreateRoomException { 
        super(null);
        if (HotelService.get().hotel.roomService.getRooms().findByNumber(number) != null) { throw new CreateRoomException("duplicate room number"); }

        this.number = number;
        this.capacity = capacity;
        this.stars = stars; 
    }

    public int getNumber() { return this.number; };
    public int getCapacity() { return this.capacity; };
    public int getStars() { return this.stars; };
    public Client getClient() { return this.client; };
    public RoomStatus getStatus() { return this.status; };
    public LocalDate getEvictionDate() { return this.evictionDate; };
    public ClientsCollection getLastClients() { return this.lastClients; };
    public float getPrice() { return this.price; }

    public void setNumber(int number) { this.number = number; };
    public void setCapacity(int capacity) { this.capacity = capacity; };
    public void setClient(Client client) { this.client = client; };
    public void setStars(int stars) { this.stars = stars; };
    public void setEvictionDate(LocalDate evictionDate) { this.evictionDate = evictionDate; };

    public void setStatus(RoomStatus newStatus) {
        if (!Config.canChangeRoomStatus()) { throw new ChangeRoomStatusNotAllowedException(); }
        this.status = newStatus;
    };

    public boolean setPrice(float newPrice) throws UpdateRoomException {
        if (newPrice <= 0) { throw new UpdateRoomException("price must be more then zero"); }

        this.price = newPrice;
        return true;
    }

    @Override
    public String toString() {
        String statusString = this.status == null ? "" : String.format(" (%s)", this.status);
        int clientsCount = this.client == null ? 0 : 1;
        return String.format("<Room#%d%s price: %s stars: %d capacity: %d/%d>", this.getID(), statusString, this.getPrice(), this.stars, clientsCount, this.capacity);
    }
}