package hotel.services;

import hotel.config.AutoDI;
import hotel.models.Hotel;
import java.io.Serializable;

public class HotelService implements Serializable {
    @AutoDI
    private static HotelService singleton;
    public static HotelService get() { return singleton; }

    @AutoDI
    public Hotel hotel;
}
