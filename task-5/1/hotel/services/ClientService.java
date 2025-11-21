package hotel.services;

import hotel.collections.ClientsCollection;
import hotel.models.Client;
import hotel.models.Room;
import hotel.storages.ClientsStorage;

public class ClientService {
    private final ClientsCollection clients = new ClientsCollection();
    private final ClientsStorage storage = new ClientsStorage(this);

    public ClientsCollection getClients() { return this.clients; };
    public void addClient(Client client) { this.clients.get().add(client); };

    public void destroyClient(Integer id) {
        Client client = getClient(id);
        if (client == null) return;

        Room room = client.getRoom();
        if (room != null) HotelService.get().getRoomService().evictFrom(room.getNumber());

        this.clients.get().remove(client);
    };

    public Client getClient(Integer id) { return clients.find(id); }

    public void saveClient(Integer id) { this.storage.saveClient(getClient(id)); };
    public void saveClients() { this.storage.saveClients(); };
    public void loadClients() { this.storage.loadClients(); };
}
