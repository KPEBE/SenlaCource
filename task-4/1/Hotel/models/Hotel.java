package hotel.models;

import java.util.ArrayList;
import hotel.services.*;

public class Hotel {
    public final RoomService RoomService = new RoomService();
    public final ServiceService ServiceService = new ServiceService();
    public final ClientService ClientService = new ClientService();
}