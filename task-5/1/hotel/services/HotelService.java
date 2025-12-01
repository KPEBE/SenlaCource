package hotel.services;

import hotel.lib.Serializer;
import hotel.models.Hotel;
import java.io.Serializable;

public class HotelService implements Serializable {
    private static HotelService singleton;
    public static HotelService get() {
        if (singleton == null) { singleton = Serializer.loadHotel(); }
        return singleton;
    }

    private final Hotel hotel = new Hotel();

    public RoomService getRoomService() { return this.hotel.roomService; };
    public ServiceService getServiceService() { return this.hotel.serviceService; };
    public ClientService getClientService() { return this.hotel.clientService; };
}
