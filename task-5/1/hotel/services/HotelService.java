package hotel.services;

import hotel.models.Hotel;

public class HotelService {
    private static HotelService singleton;
    public static HotelService get() {
        if (singleton == null) { singleton = new HotelService(); }
        return singleton;
    }

    private final Hotel hotel = new Hotel();

    public RoomService getRoomService() { return this.hotel.roomService; };
    public ServiceService getServiceService() { return this.hotel.serviceService; };
    public ClientService getClientService() { return this.hotel.clientService; };
}
