package hotel.collections;

import hotel.models.Room;
import java.util.Comparator;
import java.util.List;

public class RoomsCollection extends BaseCollection<Room, RoomsCollection> {
    @Override
    protected RoomsCollection New(List<Room> elements) { return new RoomsCollection(elements); }
    public RoomsCollection() { super(); }
    public RoomsCollection(List<Room> elements) { super(elements); }

    public RoomsCollection emptyRooms() { return this.filter(r->r.getClient() == null); }

    public RoomsCollection sortByPrice() { return this.sort(Comparator.comparing(Room::getPrice)); }
    public RoomsCollection sortByCapacity() { return this.sort(Comparator.comparing(Room::getCapacity)); }
    public RoomsCollection sortByStars() { return this.sort(Comparator.comparing(Room::getStars)); }
}