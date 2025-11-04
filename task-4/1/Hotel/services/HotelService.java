package hotel.services;

import hotel.models.Hotel;
import hotel.collections.*;

public class HotelService {
    private final Hotel hotel = new Hotel();

    public RoomService GetRoomService() { return this.hotel.RoomService; };
    public ServiceService GetServiceService() { return this.hotel.ServiceService; };
    public ClientService GetClientService() { return this.hotel.ClientService; };
}
