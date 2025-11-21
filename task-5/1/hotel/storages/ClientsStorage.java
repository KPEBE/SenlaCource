package hotel.storages;

import hotel.models.Client;
import hotel.models.Room;
import hotel.services.ClientService;
import hotel.services.HotelService;

public class ClientsStorage extends Storage {
  private final String CLIENT_DATA_PATH = String.format("%s/%s.csv", DATA_DIR, "clients");

  private final ClientService clientService;

  public ClientsStorage(ClientService clientService) { this.clientService = clientService; }

  public void loadClients() { loadFromCSV(CLIENT_DATA_PATH, p->loadClient(p)); }
  public void saveClients() { recreateFile(CLIENT_DATA_PATH); clientService.getClients().each(r->saveToCSV(CLIENT_DATA_PATH, clientParams(r)));  }
  public void saveClient(Client client) { saveToCSV(CLIENT_DATA_PATH, clientParams(client));  }

  public void loadClient(String[] params) {
    if (params.length != 3) { System.out.println("Incorrect params count"); return; }

    Integer id = Integer.parseInt(params[0]);
    String name = params[1];

    Room room = null;
    if (params[2] != "") {
      Integer roomId = Integer.parseInt(params[2]);
      room = HotelService.get().getRoomService().getRoom(roomId);
    }

    Client client = clientService.getClient(id);

    if (client == null) {
      client = new Client(id);
      clientService.addClient(client);
    }

    client.setFullname(name);
    client.setRoom(room);
  }

  private Object[] clientParams(Client client) {
    Integer id = client.getID();
    String name = client.getFullname();
    Room room = client.getRoom();
    Integer roomId = room == null ? null : room.getID();

    return new Object[] { id, name, roomId };
  }
}