package hotel.services;

import hotel.collections.ClientsCollection;
import hotel.models.Client;
import hotel.models.Room;

public class ClientService {
    private final ClientsCollection clients = new ClientsCollection();

    public ClientsCollection getClients() { return this.clients; };
    public void addClient(Client client) { this.clients.get().add(client); };

    public void destroyClient(String name) {
        Client client = getClient(name);
        if (client == null) return;

        Room room = client.getRoom();
        if (room != null) HotelService.get().getRoomService().evictFrom(room.getNumber());

        this.clients.get().remove(client);
    };

    public Client getClient(String name) {
        Client foundClient = null;
        for ( Client client : this.clients.get() ) {
            if (client.getFullname().equals(name)) { foundClient = client; }
        }
        return foundClient;
    }
}
