package hotel.models;

import hotel.collections.ClientsCollection;
import hotel.enums.RoomStatus;
import hotel.interfaces.IInspectable;
import java.time.LocalDate;

public class Room implements IInspectable {
    private final int number;
    private final int capacity;
    private int stars;
    private LocalDate evictionDate;
    private RoomStatus status;
    private Client client;
    private final ClientsCollection lastClients = new ClientsCollection();
    private float price = 0.0f;

    public Room(int number) { this.number = number; this.capacity = 1; this.stars = 0; }
    public Room(int number, int capacity) { this.number = number; this.capacity = capacity; this.stars = 0; }
    public Room(int number, int capacity, int stars) { this.number = number; this.capacity = capacity; this.stars = stars; }

    public int getNumber() { return this.number; };
    public int getCapacity() { return this.capacity; };
    public int getStars() { return this.stars; };
    public Client getClient() { return this.client; };
    public RoomStatus getStatus() { return this.status; };
    public LocalDate getEvictionDate() { return this.evictionDate; };
    public ClientsCollection getLastClients() { return this.lastClients; };
    public float getPrice() { return this.price; }

    public void setClient(Client client) { this.client = client; };
    public void setStatus(RoomStatus newStatus) { this.status = newStatus; };
    public void setStars(int stars) { this.stars = stars; };
    public void setEvictionDate(LocalDate evictionDate) { this.evictionDate = evictionDate; };

    public boolean setPrice(float newPrice) {
        if (newPrice <= 0) { return false; }

        this.price = newPrice;
        return true;
    }

    @Override
    public String toString() {
        String statusString = this.status == null ? "" : String.format(" (%s)", this.status);
        int clientsCount = this.client == null ? 0 : 1;
        return String.format("<Room#%d%s price: %s stars: %d capacity: %d/%d>", this.number, statusString, this.getPrice(), this.stars, clientsCount, this.capacity);
    }
}