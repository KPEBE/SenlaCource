package hotel.services;

import hotel.collections.ClientsCollection;
import hotel.config.AutoDI;
import hotel.models.Client;
import hotel.models.Room;
import hotel.storages.ClientsStorage;
import java.io.Serializable;

public class ClientService implements Serializable {
    @AutoDI
    private ClientsCollection clients;

    @AutoDI
    private transient ClientsStorage storage;

    public ClientsStorage getStorage() { return this.storage; }
    public ClientsCollection getClients() { return this.clients; };
    public void addClient(Client client) { this.clients.get().add(client); };

    public void destroyClient(Integer id) {
        Client client = getClient(id);
        if (client == null) return;

        Room room = client.getRoom();
        if (room != null) HotelService.get().hotel.roomService.evictFrom(room.getNumber());

        this.clients.get().remove(client);
    };

    public Client getClient(Integer id) { return clients.find(id); }

    public void saveClient(Integer id) { getStorage().saveClient(getClient(id)); };
    public void saveClients() { getStorage().saveClients(); };
    public void loadClients() { getStorage().loadClients(); };
}
