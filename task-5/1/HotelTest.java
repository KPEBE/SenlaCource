import hotel.collections.*;
import hotel.config.AppLoader;
import hotel.config.Config;
import hotel.config.Router;
import hotel.config.Serializer;
import hotel.enums.*;
import hotel.models.*;
import hotel.services.*;
import java.time.LocalDate;

public class HotelTest {
    public static void main(String[] args) {
        try {
            AppLoader.load();
            Config.loadConfig();
            // testHotel();
            loadData();
            showUI();
            Serializer.saveHotel();
        } catch (Exception e) {
            System.err.printf("Catch error on top level: %s\n", e.toString());
            e.printStackTrace();
        }
    }

    private static void testHotel() { 
        HotelService hotelService = HotelService.get();
        System.out.println("Hotel Created");

        hotelService.hotel.roomService.addRoom(new Room(1, 2, 0));
        hotelService.hotel.roomService.addRoom(new Room(2, 1, 4));
        hotelService.hotel.roomService.addRoom(new Room(3, 1, 1));
        System.out.println("Rooms in Hotel:");
        hotelService.hotel.roomService.getRooms().show();

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

        hotelService.hotel.serviceService.addService(service1);
        hotelService.hotel.serviceService.addService(service2);
        hotelService.hotel.serviceService.addService(service3);
        hotelService.hotel.serviceService.addService(service4);
        hotelService.hotel.serviceService.addService(service5);
        System.out.println("Services in Hotel:");
        hotelService.hotel.serviceService.getServices().show();
        System.out.println("Services in Hotel By Type:");
        hotelService.hotel.serviceService.getServices().sortByType().show();
        System.out.println("Services in Hotel By Price:");
        hotelService.hotel.serviceService.getServices().sortByPrice().show();

        Room mainRoom = hotelService.hotel.roomService.getRoom(2);
        mainRoom.setPrice(120.5f);
        System.out.printf("New second room price: %s\n", mainRoom.getPrice() );

        hotelService.hotel.roomService.changeStatusOf(1, RoomStatus.REPAIRING);
        hotelService.hotel.roomService.changeStatusOf(3, RoomStatus.SERVICING);

        Client client = new Client("Ivanov I.I.");
        System.out.printf("Create new client %s\n", client.getFullname() );
        hotelService.hotel.clientService.addClient(client);
        Client client2 = new Client("Alex S.T.");
        hotelService.hotel.clientService.addClient(client2);

        hotelService.hotel.roomService.populateTo(2, client, LocalDate.of(2025, 12, 10));
        System.out.printf("Client Must Pay: %s\n", client.getRoom().getPrice());

        RoomsCollection allRooms = hotelService.hotel.roomService.getRooms();
        System.out.println("Rooms in Hotel By Price:");
        allRooms.sortByPrice().show();
        System.out.println("Rooms in Hotel By Capacity:");
        allRooms.sortByCapacity().show();
        System.out.println("Rooms in Hotel By Start:");
        allRooms.sortByStars().show();
        System.out.printf("Empty Rooms in Hotel: %d\n", allRooms.emptyRooms().get().size());
        allRooms.emptyRooms().show();

        hotelService.hotel.roomService.evictFrom(2);
        hotelService.hotel.roomService.populateTo(2, client2, LocalDate.of(2025, 12, 25));
        System.out.println("Room`s last 3 clients:");
        mainRoom.getLastClients().limit(3).show();

        ClientsCollection allClients = hotelService.hotel.clientService.getClients();
        System.out.printf("Clients in Hotel: %d\n", allClients.get().size());
        allClients.show();
        System.out.println("Clients in Hotel By Name:");
        allClients.sortByName().show();
        System.out.println("Rooms in Hotel By EvictionDate:");
        allClients.sortByEvictionDate().show();
    }

    private static void loadData() {
        HotelService.get().hotel.serviceService.loadServices();
        HotelService.get().hotel.clientService.loadClients();
        HotelService.get().hotel.roomService.loadRooms();
    }

    private static void showUI() {
        while (true) {
            try {
                Router router = Router.get();
                router.toHotels();
                break;
            }
            catch (StackOverflowError e) {
                System.err.println("Stack Overflow in showUI");
                e.printStackTrace();
                break;
            } 
            catch (Exception e) {
                System.err.printf("Catch error on showUI: %s\n", e.toString());
                e.printStackTrace();
            }    
        }
    }
}