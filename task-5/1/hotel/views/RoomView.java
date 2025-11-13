package hotel.views;

import hotel.enums.RoomStatus;
import hotel.lib.InputUtils;
import hotel.lib.Router;
import hotel.models.Room;
import java.util.ArrayList;

public class RoomView extends View {

    public void index(ArrayList<Room> rooms) {
        clear();
        print("Rooms Menu");
        gap();
        print("1. Add New Room");
        gap();
        int index = 2;
        for ( Room room : rooms ) {
            print(String.format("%d. %s", index, room.toString()));
            addAction(index, ()->{ Router.toShowRoom(room.getNumber()); });
            index++;
        }
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toCreateRoom(inputNumber(), inputCapacity(), inputStars(), inputPrice()); });
        addAction(0, ()->{ Router.toHotels(); });

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
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toUpdateRoom(room.getNumber(), RoomStatus.REPAIRING, null, null); });
        addAction(2, ()->{ Router.toUpdateRoom(room.getNumber(), RoomStatus.SERVICING, null, null); });
        addAction(3, ()->{ Router.toUpdateRoom(room.getNumber(), null, null, null); });
        addAction(4, ()->{ Router.toUpdateRoom(room.getNumber(), room.getStatus(), null, inputPrice()); });
        addAction(5, ()->{ Router.toUpdateRoom(room.getNumber(), room.getStatus(), inputStars(), null); });
        addAction(6, ()->{ Router.toEvictClient(room.getNumber()); });
        addAction(7, ()->{ Router.toPopulateClient(room.getNumber(), inputClientName()); });

        addAction(9, ()->{ Router.toDestroyRoom(room.getNumber()); });
        addAction(0, ()->{ Router.toRooms(); });

        runAction();
    }

    private int inputNumber() { return InputUtils.readInt("Enter number: "); }
    private float inputPrice() { return InputUtils.readFloat("Enter price: "); }
    private int inputCapacity() { return InputUtils.readInt("Enter capacity: "); }
    private int inputStars() { return InputUtils.readInt("Enter stars: "); }

    private String inputClientName() { return InputUtils.readString("Enter Client Fullname: "); }
}