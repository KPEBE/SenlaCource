package hotel.models;

import hotel.config.AutoDI;
import hotel.services.*;
import java.io.Serializable;

public class Hotel implements Serializable {
    @AutoDI
    public RoomService roomService;

    @AutoDI
    public ServiceService serviceService;

    @AutoDI
    public ClientService clientService;
}