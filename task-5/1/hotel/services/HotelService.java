package hotel.services;

import hotel.models.Hotel;

public class HotelService {
    private final static HotelService singleton = new HotelService();
    public static HotelService get() { return singleton; }

    private final Hotel hotel = new Hotel();

    public RoomService getRoomService() { return this.hotel.roomService; };
    public ServiceService getServiceService() { return this.hotel.serviceService; };
    public ClientService getClientService() { return this.hotel.clientService; };
}
