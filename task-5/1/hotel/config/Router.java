package hotel.config;

import hotel.controllers.*;
import hotel.enums.RoomStatus;
import hotel.enums.ServiceType;

public class Router {
    @AutoDI
    private static Router router;
    public static Router get() {  return router; }

    @AutoDI
    private HotelController hotelController;

    @AutoDI
    private ClientController clientController;

    @AutoDI
    private RoomController roomController;

    @AutoDI
    private ServiceController serviceController;

    public void toHotels() { hotelController.show(); }

    public void toRooms() { roomController.index(); }
    public void toCreateRoom(int number, int capacity, int stars, float price) { roomController.create(number, capacity, stars, price); }
    public void toShowRoom(int id) { roomController.show(id); }
    public void toUpdateRoom(int id, RoomStatus status, Integer stars, Float price) { roomController.update(id, status, stars, price); }
    public void toDestroyRoom(int id) { roomController.destroy(id); }
    public void toEvictClient(int id) { roomController.evict(id); }
    public void toPopulateClient(int id, int clientId) { roomController.populate(id, clientId); }
    public void toSaveRoom(int id) { roomController.saveRoom(id); }
    public void toSaveRooms() { roomController.saveRooms(); }
    public void toLoadRooms() { roomController.loadRooms(); }

    public void toServices() { serviceController.index(); }
    public void toCreateService(String title, ServiceType type, float price) { serviceController.create(title, type, price); }
    public void toShowService(int id) { serviceController.show(id); }
    public void toUpdateService(int id, String newTitle, Float price) { serviceController.update(id, newTitle, price); }
    public void toDestroyService(int id) { serviceController.destroy(id); }
    public void toSaveService(int id) { serviceController.saveService(id); }
    public void toSaveServices() { serviceController.saveServices(); }
    public void toLoadServices() { serviceController.loadServices(); }

    public void toClients() { clientController.index(); }
    public void toCreateClient(String name) { clientController.create(name); }
    public void toShowClient(int id) { clientController.show(id); }
    public void toUpdateClient(int id, String newName) { clientController.update(id, newName); }
    public void toDestroyClient(int id) { clientController.destroy(id); }
    public void toSaveClient(int id) { clientController.saveClient(id); }
    public void toSaveClients() { clientController.saveClients(); }
    public void toLoadClients() { clientController.loadClients(); }
}