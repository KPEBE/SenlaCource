package hotel.views;

import hotel.config.InputUtils;
import hotel.config.Router;
import hotel.enums.ServiceType;
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

        addAction(1, ()->{ Router.get().toCreateService(inputTitle(), inpuServiceType(), inputPrice()); });
        addAction(2, ()->{ Router.get().toSaveServices(); });
        addAction(3, ()->{ Router.get().toLoadServices(); });
        addAction(0, ()->{ Router.get().toHotels(); });

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

        addAction(1, ()->{ Router.get().toUpdateService(service.getID(), null, inputPrice()); });
        addAction(2, ()->{ Router.get().toUpdateService(service.getID(), inputTitle(), null); });

        addAction(3, ()->{ Router.get().toDestroyService(service.getID()); });

        addAction(9, ()->{ Router.get().toSaveService(service.getID()); });
        addAction(0, ()->{ Router.get().toServices(); });

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
            addAction(index, ()->{ Router.get().toShowService(service.getID()); });
            index++;
        }
    }
}