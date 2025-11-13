package hotel.controllers;

import hotel.models.Client;
import hotel.services.HotelService;
import hotel.views.ClientView;
import java.util.ArrayList;

public class ClientController {

    private final ClientView view = new ClientView();

    public void index() {
        ArrayList<Client> clients = HotelService.get().getClientService().getClients().get();
        view.index(clients);
    }

    public void show(String name) {
        Client client = HotelService.get().getClientService().getClient(name);
        view.show(client);
    }

    public void create(String name) {
        Client client = new Client(name);
        HotelService.get().getClientService().addClient(client);
        this.index();
    }

    public void update(String name, String newName) {
        Client client = HotelService.get().getClientService().getClient(name);
        client.setFullname(newName);
        view.show(client);
    }

    public void destroy(String name) {
        HotelService.get().getClientService().destroyClient(name);
        this.index();
    }
}