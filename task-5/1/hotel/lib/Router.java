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
    public static void toShowRoom(int id) { roomController.show(id); }
    public static void toUpdateRoom(int id, RoomStatus status, Integer stars, Float price) { roomController.update(id, status, stars, price); }
    public static void toDestroyRoom(int id) { roomController.destroy(id); }
    public static void toEvictClient(int id) { roomController.evict(id); }
    public static void toPopulateClient(int id, int clientId) { roomController.populate(id, clientId); }
    public static void toSaveRoom(int id) { roomController.saveRoom(id); }
    public static void toSaveRooms() { roomController.saveRooms(); }
    public static void toLoadRooms() { roomController.loadRooms(); }

    public static void toServices() { serviceController.index(); }
    public static void toCreateService(String title, ServiceType type, float price) { serviceController.create(title, type, price); }
    public static void toShowService(int id) { serviceController.show(id); }
    public static void toUpdateService(int id, String newTitle, Float price) { serviceController.update(id, newTitle, price); }
    public static void toDestroyService(int id) { serviceController.destroy(id); }
    public static void toSaveService(int id) { serviceController.saveService(id); }
    public static void toSaveServices() { serviceController.saveServices(); }
    public static void toLoadServices() { serviceController.loadServices(); }

    public static void toClients() { clientController.index(); }
    public static void toCreateClient(String name) { clientController.create(name); }
    public static void toShowClient(int id) { clientController.show(id); }
    public static void toUpdateClient(int id, String newName) { clientController.update(id, newName); }
    public static void toDestroyClient(int id) { clientController.destroy(id); }
    public static void toSaveClient(int id) { clientController.saveClient(id); }
    public static void toSaveClients() { clientController.saveClients(); }
    public static void toLoadClients() { clientController.loadClients(); }
}