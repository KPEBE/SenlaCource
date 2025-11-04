package hotel.collections;

import java.util.Comparator;
import java.util.List;
import hotel.models.Room;

public class RoomsCollection extends BaseCollection<Room, RoomsCollection> {
    @Override
    protected RoomsCollection New(List<Room> elements) { return new RoomsCollection(elements); }
    public RoomsCollection() { super(); }
    public RoomsCollection(List<Room> elements) { super(elements); }

    public RoomsCollection EmptyRooms() { return this.Filter(r->r.GetClient() == null); }

    public RoomsCollection SortByPrice() { return this.Sort(Comparator.comparing(Room::GetPrice)); }
    public RoomsCollection SortByCapacity() { return this.Sort(Comparator.comparing(Room::GetCapacity)); }
    public RoomsCollection SortByStars() { return this.Sort(Comparator.comparing(Room::GetStars)); }
}