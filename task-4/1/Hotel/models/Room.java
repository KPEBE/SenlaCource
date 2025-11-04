package hotel.models;

import java.time.LocalDate;
import hotel.enums.RoomStatus;

import hotel.interfaces.IInspectable;
import hotel.lib.PurchasableObject;
import hotel.collections.ClientsCollection;

public class Room extends PurchasableObject implements IInspectable {
    private int number;
    private int capacity;
    private int stars;
    private LocalDate evictionDate;
    private RoomStatus status;
    private Client client;
    private final ClientsCollection lastClients = new ClientsCollection();

    public Room(int number) { this.number = number; this.capacity = 1; this.stars = 0; }
    public Room(int number, int capacity) { this.number = number; this.capacity = capacity; this.stars = 0; }
    public Room(int number, int capacity, int stars) { this.number = number; this.capacity = capacity; this.stars = stars; }

    public int GetNumber() { return this.number; };
    public int GetCapacity() { return this.capacity; };
    public int GetStars() { return this.stars; };
    public Client GetClient() { return this.client; };
    public RoomStatus GetStatus() { return this.status; };
    public LocalDate GetEvictionDate() { return this.evictionDate; };
    public ClientsCollection GetLastClients() { return this.lastClients; };

    public void SetClient(Client client) { this.client = client; };
    public void SetStatus(RoomStatus newStatus) { this.status = newStatus; };
    public void SetEvictionDate(LocalDate evictionDate) { this.evictionDate = evictionDate; };

    public void Inspect() {
        String status = this.status == null ? "" : String.format(" (%s)", this.status);
        int clientsCount = this.client == null ? 0 : 1;
        System.out.printf("<Room#%d%s price: %s stars: %d capacity: %d/%d>\n", this.number, status, this.GetPrice(), this.stars, clientsCount, this.capacity);
    }
}