import hotel.collections.*;
import hotel.enums.*;
import hotel.lib.Router;
import hotel.models.*;
import hotel.services.*;
import java.time.LocalDate;

public class HotelTest {
    public static void main(String[] args) {
        HotelService hotelService = HotelService.get();
        System.out.println("Hotel Created");

        hotelService.getRoomService().addRoom(new Room(1, 2, 0));
        hotelService.getRoomService().addRoom(new Room(2, 1, 4));
        hotelService.getRoomService().addRoom(new Room(3, 1, 1));
        System.out.println("Rooms in Hotel:");
        hotelService.getRoomService().getRooms().show();

        Service service1 = new Service("Semi Cleaning", ServiceType.CLEANING);
        service1.setPrice(30.0f);
        Service service2 = new Service("Full Cleaning", ServiceType.CLEANING);
        service2.setPrice(45.5f);
        Service service3 = new Service("Breakfast", ServiceType.COOKING);
        service3.setPrice(12f);
        Service service4 = new Service("Lunch", ServiceType.COOKING);
        service4.setPrice(12f);
        Service service5 = new Service("Dinner", ServiceType.COOKING);
        service5.setPrice(15f);

        hotelService.getServiceService().addService(service1);
        hotelService.getServiceService().addService(service2);
        hotelService.getServiceService().addService(service3);
        hotelService.getServiceService().addService(service4);
        hotelService.getServiceService().addService(service5);
        System.out.println("Services in Hotel:");
        hotelService.getServiceService().getServices().show();
        System.out.println("Services in Hotel By Type:");
        hotelService.getServiceService().getServices().sortByType().show();
        System.out.println("Services in Hotel By Price:");
        hotelService.getServiceService().getServices().sortByPrice().show();

        Room mainRoom = hotelService.getRoomService().getRoom(2);
        mainRoom.setPrice(120.5f);
        System.out.printf("New second room price: %s\n", mainRoom.getPrice() );

        hotelService.getRoomService().changeStatusOf(1, RoomStatus.REPAIRING);
        hotelService.getRoomService().changeStatusOf(3, RoomStatus.SERVICING);

        Client client = new Client("Ivanov I.I.");
        System.out.printf("Create new client %s\n", client.getFullname() );
        hotelService.getClientService().addClient(client);
        Client client2 = new Client("Alex S.T.");
        hotelService.getClientService().addClient(client2);

        hotelService.getRoomService().populateTo(2, client, LocalDate.of(2025, 12, 10));
        System.out.printf("Client Must Pay: %s\n", client.getRoom().getPrice());

        RoomsCollection allRooms = hotelService.getRoomService().getRooms();
        System.out.println("Rooms in Hotel By Price:");
        allRooms.sortByPrice().show();
        System.out.println("Rooms in Hotel By Capacity:");
        allRooms.sortByCapacity().show();
        System.out.println("Rooms in Hotel By Start:");
        allRooms.sortByStars().show();
        System.out.printf("Empty Rooms in Hotel: %d\n", allRooms.emptyRooms().get().size());
        allRooms.emptyRooms().show();

        hotelService.getRoomService().evictFrom(2);
        hotelService.getRoomService().populateTo(2, client2, LocalDate.of(2025, 12, 25));
        System.out.println("Room`s last 3 clients:");
        mainRoom.getLastClients().limit(3).show();

        ClientsCollection allClients = hotelService.getClientService().getClients();
        System.out.printf("Clients in Hotel: %d\n", allClients.get().size());
        allClients.show();
        System.out.println("Clients in Hotel By Name:");
        allClients.sortByName().show();
        System.out.println("Rooms in Hotel By EvictionDate:");
        allClients.sortByEvictionDate().show();

        Router.toHotels();
    }
}