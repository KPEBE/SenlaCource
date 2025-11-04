import hotel.collections.*;
import hotel.services.*;
import hotel.models.*;
import hotel.enums.*;
import java.time.LocalDate;

public class HotelTest {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        System.out.println("Hotel Created");

        hotelService.GetRoomService().AddRoom(new Room(1, 2, 0));
        hotelService.GetRoomService().AddRoom(new Room(2, 1, 4));
        hotelService.GetRoomService().AddRoom(new Room(3, 1, 1));
        System.out.println("Rooms in Hotel:");
        hotelService.GetRoomService().GetRooms().Show();

        hotelService.GetServiceService().AddService(new Service("Semi Cleaning", ServiceType.CLEANING, 30.0f));
        hotelService.GetServiceService().AddService(new Service("Full Cleaning", ServiceType.CLEANING, 45.5f));
        hotelService.GetServiceService().AddService(new Service("Breakfast", ServiceType.COOKING, 12f));
        hotelService.GetServiceService().AddService(new Service("Lunch", ServiceType.COOKING, 12f));
        hotelService.GetServiceService().AddService(new Service("Dinner", ServiceType.COOKING, 15f));
        System.out.println("Services in Hotel:");
        hotelService.GetServiceService().GetServices().Show();
        System.out.println("Services in Hotel By Type:");
        hotelService.GetServiceService().GetServices().SortByType().Show();
        System.out.println("Services in Hotel By Price:");
        hotelService.GetServiceService().GetServices().SortByPrice().Show();

        Room mainRoom = hotelService.GetRoomService().GetRoom(2);
        mainRoom.SetPrice(120.5f);
        System.out.printf("New second room price: %s\n", mainRoom.GetPrice() );

        hotelService.GetRoomService().ChangeStatusOf(1, RoomStatus.REPAIRING);
        hotelService.GetRoomService().ChangeStatusOf(3, RoomStatus.SERVICING);

        Client client = new Client("Ivanov I.I.");
        System.out.printf("Create new client %s\n", client.GetFullname() );
        hotelService.GetClientService().AddClient(client);
        Client client2 = new Client("Alex S.T.");
        hotelService.GetClientService().AddClient(client2);

        hotelService.GetRoomService().PopulateTo(2, client, LocalDate.of(2025, 12, 10));
        System.out.printf("Client Must Pay: %s\n", client.GetRoom().GetPrice());

        RoomsCollection allRooms = hotelService.GetRoomService().GetRooms();
        System.out.println("Rooms in Hotel By Price:");
        allRooms.SortByPrice().Show();
        System.out.println("Rooms in Hotel By Capacity:");
        allRooms.SortByCapacity().Show();
        System.out.println("Rooms in Hotel By Start:");
        allRooms.SortByStars().Show();
        System.out.printf("Empty Rooms in Hotel: %d\n", allRooms.EmptyRooms().Get().size());
        allRooms.EmptyRooms().Show();

        hotelService.GetRoomService().EvictFrom(2);
        hotelService.GetRoomService().PopulateTo(2, client2, LocalDate.of(2025, 12, 25));
        System.out.println("Room`s last 3 clients:");
        mainRoom.GetLastClients().Limit(3).Show();

        ClientsCollection allClients = hotelService.GetClientService().GetClients();
        System.out.printf("Clients in Hotel: %d\n", allClients.Get().size());
        allClients.Show();
        System.out.println("Clients in Hotel By Name:");
        allClients.SortByName().Show();
        System.out.println("Rooms in Hotel By EvictionDate:");
        allClients.SortByEvictionDate().Show();
    }
}