package hotel.views;

import hotel.lib.InputUtils;
import hotel.lib.Router;
import hotel.models.Client;
import java.util.ArrayList;

public class ClientView extends View {

    public void index(ArrayList<Client> clients) {
        clear();
        print("Clients Menu");
        gap();
        print("1. Add New Client");
        gap();
        int index = 2;
        for ( Client client : clients ) {
            print(String.format("%d. %s", index, client.toString()));
            addAction(index, ()->{ Router.toShowClient(client.getFullname()); });
            index++;
        }
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toCreateClient(inputClientName()); });
        addAction(0, ()->{ Router.toHotels(); });

        runAction();
    }

    public void show(Client client) {
        clear();
        print("Client Menu");
        print(client.toString());
        gap();
        print("1. Destroy Client");
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toDestroyClient(client.getFullname()); });
        addAction(0, ()->{ Router.toClients(); });

        runAction();
    }

    private String inputClientName() { return InputUtils.readString("Enter Client Fullname: "); }
}