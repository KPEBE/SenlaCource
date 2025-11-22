package hotel.models;

import hotel.services.*;
import java.io.Serializable;

public class Hotel implements Serializable {
    public final RoomService roomService = new RoomService();
    public final ServiceService serviceService = new ServiceService();
    public final ClientService clientService = new ClientService();
}