package hotel.lib;

import hotel.controllers.*;
import hotel.enums.RoomStatus;
import hotel.enums.ServiceType;

public class Router {
    private final static HotelController hotelController = new HotelController();
    private final static ClientController clientController = new ClientController();
    private final static RoomController roomController = new RoomController();
    private final static ServiceController serviceController = new ServiceController();

    public static void toHotels() { hotelController.show(); }

    public static void toRooms() { roomController.index(); }
    public static void toCreateRoom(int number, int capacity, int stars, float price) { roomController.create(number, capacity, stars, price); }
    public static void toShowRoom(int number) { roomController.show(number); }
    public static void toUpdateRoom(int number, RoomStatus status, Integer stars, Float price) { roomController.update(number, status, stars, price); }
    public static void toDestroyRoom(int number) { roomController.destroy(number); }
    public static void toEvictClient(int number) { roomController.evict(number); }
    public static void toPopulateClient(int number, String clientName) { roomController.populate(number, clientName); }

    public static void toServices() { serviceController.index(); }
    public static void toCreateService(String title, ServiceType type, float price) { serviceController.create(title, type, price); }
    public static void toShowService(String title) { serviceController.show(title); }
    public static void toUpdateService(String title, String newTitle, Float price) { serviceController.update(title, newTitle, price); }
    public static void toDestroyService(String title) { serviceController.destroy(title); }

    public static void toClients() { clientController.index(); }
    public static void toCreateClient(String name) { clientController.create(name); }
    public static void toShowClient(String name) { clientController.show(name); }
    public static void toUpdateClient(String name, String newName) { clientController.update(name, newName); }
    public static void toDestroyClient(String name) { clientController.destroy(name); }
}