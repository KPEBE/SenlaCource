package hotel.views;

import hotel.config.InputUtils;
import hotel.config.Router;
import hotel.enums.RoomStatus;
import hotel.models.Room;
import java.util.ArrayList;

public class RoomView extends View {

    public void index(ArrayList<Room> rooms) {
        clear();
        print("Rooms Menu");
        gap();
        print("1. Add New Room");
        gap();
        print("2. Save Rooms");
        print("3. Load Rooms");
        gap();
        printRooms(rooms);
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.get().toCreateRoom(inputNumber(), inputCapacity(), inputStars(), inputPrice()); });
        addAction(2, ()->{ Router.get().toSaveRooms(); });
        addAction(3, ()->{ Router.get().toLoadRooms(); });
        addAction(0, ()->{ Router.get().toHotels(); });

        runAction();
    }

    public void show(Room room) {
        clear();
        print("Room Menu");
        print(room.toString());
        gap();
        print(String.format("1. Change status to %s", RoomStatus.REPAIRING));
        print(String.format("2. Change status to %s", RoomStatus.SERVICING));
        print("3. Clear status");
        gap();
        print("4. Change price");
        print("5. Change stars");
        gap();
        print("6. Evict Client");
        print("7. Populate Client");
        gap();
        print("9. Destroy Room");
        gap();
        print("10. Save Room");
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.get().toUpdateRoom(room.getID(), RoomStatus.REPAIRING, null, null); });
        addAction(2, ()->{ Router.get().toUpdateRoom(room.getID(), RoomStatus.SERVICING, null, null); });
        addAction(3, ()->{ Router.get().toUpdateRoom(room.getID(), null, null, null); });
        addAction(4, ()->{ Router.get().toUpdateRoom(room.getID(), room.getStatus(), null, inputPrice()); });
        addAction(5, ()->{ Router.get().toUpdateRoom(room.getID(), room.getStatus(), inputStars(), null); });
        addAction(6, ()->{ Router.get().toEvictClient(room.getID()); });
        addAction(7, ()->{ Router.get().toPopulateClient(room.getID(), inputClientId()); });

        addAction(9, ()->{ Router.get().toDestroyRoom(room.getID()); });
        addAction(10, ()->{ Router.get().toSaveRoom(room.getID()); });
        addAction(0, ()->{ Router.get().toRooms(); });

        runAction();
    }

    private int inputNumber() { return InputUtils.readInt("Enter number: "); }
    private float inputPrice() { return InputUtils.readFloat("Enter price: "); }
    private int inputCapacity() { return InputUtils.readInt("Enter capacity: "); }
    private int inputStars() { return InputUtils.readInt("Enter stars: "); }

    private int inputClientId() { return InputUtils.readInt("Enter Client ID: "); }

    private void printRooms(ArrayList<Room> rooms) { 
        int index = 4;
        for ( Room room : rooms ) {
            print(String.format("%d. %s", index, room.toString()));
            addAction(index, ()->{ Router.get().toShowRoom(room.getID()); });
            index++;
        }
    }
}