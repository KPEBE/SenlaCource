import Hotel.*;

public class HotelTest {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        System.out.println("Hotel Created");

        hotel.AddRoom(new Room(1));
        hotel.AddRoom(new Room(2));
        hotel.AddRoom(new Room(3));
        System.out.printf("Rooms in Hotel: %s\n", hotel.GetRooms() );

        Service service = new Service("Cleaning");
        hotel.AddService(service);
        System.out.printf("Services in Hotel: %s\n", hotel.GetServices() );

        service.SetPrice(30.9f);
        System.out.printf("New service price: %s\n", service.GetPrice() );
        hotel.GetRoom(2).SetPrice(120.5f);
        System.out.printf("New second room price: %s\n", hotel.GetRoom(2).GetPrice() );

        hotel.GetRoom(1).ChangeStatus(RoomStatus.REPAIRING);
        hotel.GetRoom(3).ChangeStatus(RoomStatus.SERVICING);

        Client client = new Client("Ivanov I.I.");
        System.out.printf("Create new client %s\n", client.GetFullname() );

        hotel.GetRoom(2).Populate(client);
        hotel.GetRoom(2).Evict();
    }
}