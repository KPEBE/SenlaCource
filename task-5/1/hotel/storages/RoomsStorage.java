package hotel.storages;

import hotel.enums.RoomStatus;
import hotel.models.Client;
import hotel.models.Room;
import hotel.services.HotelService;
import hotel.services.RoomService;
import java.time.LocalDate;

public class RoomsStorage extends Storage {
  private final String ROOM_DATA_PATH = String.format("%s/%s.csv", DATA_DIR, "rooms");

  private final RoomService roomService;

  public RoomsStorage(RoomService roomService) { this.roomService = roomService; }

  public void loadRooms() { loadFromCSV(ROOM_DATA_PATH, p->loadRoom(p)); }
  public void saveRooms() { recreateFile(ROOM_DATA_PATH); roomService.getRooms().each(r->saveToCSV(ROOM_DATA_PATH, roomParams(r)));  }
  public void saveRoom(Room room) { saveToCSV(ROOM_DATA_PATH, roomParams(room));  }

  public void loadRoom(String[] params) {
    if (params.length != 8) { System.out.println("Incorrect params count"); return; }

    Integer id = Integer.parseInt(params[0]);
    Integer number = Integer.parseInt(params[1]);
    Integer capacity = Integer.parseInt(params[2]);
    Integer stars = Integer.parseInt(params[3]);
    Float price = Float.parseFloat(params[4]);

    RoomStatus status = null;
    if (params[5] != "") {
      RoomStatus[] statuses = RoomStatus.values();
      Integer statusIndex = Integer.parseInt(params[5]);
      status = statuses[statusIndex];
    }

    LocalDate evictionDate = null;
    if (params[6] != "") {
      evictionDate = LocalDate.parse(params[6]);
    }

    Client client = null;
    if (params[7] != "") {
      Integer clientId = Integer.parseInt(params[7]);
      client = HotelService.get().getClientService().getClient(clientId);
    }

    Room room = roomService.getRoom(id);

    if (room == null) {
      room = new Room(id);
      roomService.addRoom(room);
    }

    room.setNumber(number);
    room.setCapacity(capacity);
    room.setStars(stars);
    room.setPrice(price);
    room.setStatus(status);
    room.setEvictionDate(evictionDate);
    room.setClient(client);
  }

  private Object[] roomParams(Room room) {
    Integer id = room.getID();
    Integer number = room.getNumber();
    Integer capacity = room.getCapacity();
    Integer stars = room.getStars();
    Float price = room.getPrice();
    RoomStatus status = room.getStatus();
    Integer statusIndex = status == null ? null : status.ordinal();
    LocalDate evictionDate = room.getEvictionDate();
    Client client = room.getClient();
    Integer clientId = client == null ? null : client.getID();

    return new Object[] { id, number, capacity, stars, price, statusIndex, evictionDate, clientId };
  }
}