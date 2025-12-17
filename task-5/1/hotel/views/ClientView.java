package hotel.views;

import hotel.config.InputUtils;
import hotel.config.Router;
import hotel.models.Client;
import java.util.ArrayList;

public class ClientView extends View {

    public void index(ArrayList<Client> clients) {
        clear();
        print("Clients Menu");
        gap();
        print("1. Add New Client");
        gap();
        print("2. Save Clients");
        print("3. Load Clients");
        gap();
        printClients(clients);
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.get().toCreateClient(inputClientName()); });
        addAction(2, ()->{ Router.get().toSaveClients(); });
        addAction(3, ()->{ Router.get().toLoadClients(); });
        addAction(0, ()->{ Router.get().toHotels(); });

        runAction();
    }

    public void show(Client client) {
        clear();
        print("Client Menu");
        print(client.toString());
        gap();
        print("1. Destroy Client");
        gap();
        print("9. Save Service");
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.get().toDestroyClient(client.getID()); });
        addAction(9, ()->{ Router.get().toSaveClient(client.getID()); });
        addAction(0, ()->{ Router.get().toClients(); });

        runAction();
    }

    private String inputClientName() { return InputUtils.readString("Enter Client Fullname: "); }

    private void printClients(ArrayList<Client> clients) { 
        int index = 4;
        for ( Client client : clients ) {
            print(String.format("%d. %s", index, client.toString()));
            addAction(index, ()->{ Router.get().toShowClient(client.getID()); });
            index++;
        }
    }
}