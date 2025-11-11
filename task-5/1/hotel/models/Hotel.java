package hotel.models;

import hotel.services.*;

public class Hotel {
    public final RoomService roomService = new RoomService();
    public final ServiceService serviceService = new ServiceService();
    public final ClientService clientService = new ClientService();
}