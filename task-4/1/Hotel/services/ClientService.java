package hotel.services;

import hotel.collections.ClientsCollection;
import hotel.models.Client;

public class ClientService {
    private final ClientsCollection clients = new ClientsCollection();

    public ClientsCollection GetClients() { return this.clients; };
    public void AddClient(Client client) { this.clients.Get().add(client); };
}
