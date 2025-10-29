package Hotel;

public class Room extends PurchasableObject {
    private int number;
    private RoomStatus status;
    private Client client;

    public Room(int number) { this.number = number; }

    public int GetNumber() { return this.number; };
    public RoomStatus GetStatus() { return this.status; };

    public void ChangeStatus(RoomStatus newStatus) {
        this.status = newStatus;
        System.out.printf("Room %d status change to %s\n", this.number, this.status );
    };

    public void Evict() {
        if (this.client == null) { return; };

        Client client = this.client;
        this.client = null;
        client.ChangeRoom(null);
        System.out.printf("Client %s is evict from room %d\n", client.GetFullname(), this.number );
    };

    public void Populate(Client client) {
        this.client = client;
        this.client.ChangeRoom(this);
        System.out.printf("Client %s is populated in room %d\n", client.GetFullname(), this.number );
    };
}