package hotel.views;

import hotel.enums.ServiceType;
import hotel.lib.InputUtils;
import hotel.lib.Router;
import hotel.models.Service;
import java.util.ArrayList;

public class ServiceView extends View {

    public void index(ArrayList<Service> services) {
        clear();
        print("Services Menu");
        gap();
        print("1. Add New Service");
        gap();
        print("2. Save Services");
        print("3. Load Services");
        gap();
        printServices(services);
        gap();
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toCreateService(inputTitle(), inpuServiceType(), inputPrice()); });
        addAction(2, ()->{ Router.toSaveServices(); });
        addAction(3, ()->{ Router.toLoadServices(); });
        addAction(0, ()->{ Router.toHotels(); });

        runAction();
    }

    public void show(Service service) {
        clear();
        print("Service Menu");
        print(service.toString());
        gap();
        print("1. Change price");
        print("2. Change title");
        gap();
        print("3. Destroy Service");
        gap();
        print("9. Save Service");
        print("0. Back");
        gap();

        addAction(1, ()->{ Router.toUpdateService(service.getID(), null, inputPrice()); });
        addAction(2, ()->{ Router.toUpdateService(service.getID(), inputTitle(), null); });

        addAction(3, ()->{ Router.toDestroyService(service.getID()); });

        addAction(9, ()->{ Router.toSaveService(service.getID()); });
        addAction(0, ()->{ Router.toServices(); });

        runAction();
    }


    private ServiceType inpuServiceType() {
        print("0. CLEANING");
        print("1. COOKING");
        int index = InputUtils.readInt("Enter type: ");

        ServiceType[] types = ServiceType.values();
        return types[index];
    } 

    private float inputPrice() { return InputUtils.readFloat("Enter price: "); }
    private String inputTitle() { return InputUtils.readString("Enter title: "); }

    private void printServices(ArrayList<Service> services) { 
        int index = 4;
        for ( Service service : services ) {
            print(String.format("%d. %s", index, service.toString()));
            addAction(index, ()->{ Router.toShowService(service.getID()); });
            index++;
        }
    }
}