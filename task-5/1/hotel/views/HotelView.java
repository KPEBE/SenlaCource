package hotel.views;

import hotel.lib.Router;

public class HotelView extends View {

    public void show() {
        clear();
        print("Hotel Menu");
        gap();
        print("1. Rooms");
        print("2. Services");
        print("3. Clients");
        gap();
        print("0. Exit");
        gap();

        addAction(1, ()->{ Router.toRooms(); });
        addAction(2, ()->{ Router.toServices(); });
        addAction(3, ()->{ Router.toClients(); });

        runAction();
    }

}