package hotel.controllers;

import hotel.config.AutoDI;
import hotel.models.Client;
import hotel.services.ClientService;
import hotel.views.ClientView;
import java.util.ArrayList;

public class ClientController {

    @AutoDI
    private ClientView view;

    @AutoDI
    private ClientService service;

    public void index() {
        ArrayList<Client> clients = service.getClients().get();
        view.index(clients);
    }

    public void show(int id) {
        Client client = service.getClient(id);
        view.show(client);
    }

    public void create(String name) {
        Client client = new Client(name);
        service.addClient(client);
        this.index();
    }

    public void update(int id, String newName) {
        Client client = service.getClient(id);
        client.setFullname(newName);
        view.show(client);
    }

    public void destroy(int id) {
        service.destroyClient(id);
        this.index();
    }

    public void saveClient(Integer id) {
        Client client = service.getClient(id);
        this.service.saveClient(id);
        view.show(client);
    };

    public void saveClients() { this.service.saveClients(); this.index(); };
    public void loadClients() { this.service.loadClients(); this.index(); };
}