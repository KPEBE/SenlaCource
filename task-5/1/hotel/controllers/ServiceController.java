package hotel.controllers;

import hotel.enums.ServiceType;
import hotel.models.Service;
import hotel.services.HotelService;
import hotel.services.ServiceService;
import hotel.views.ServiceView;
import java.util.ArrayList;

public class ServiceController {

    private final ServiceView view = new ServiceView();
    private final ServiceService service = HotelService.get().getServiceService();

    public void index() {
        ArrayList<Service> services = service.getServices().get();
        view.index(services);
    }

    public void show(int id) {
        Service currentService = service.getService(id);
        view.show(currentService);
    }

    public void create(String title, ServiceType type, float price) {
        Service currentService = new Service(title, type);
        currentService.setPrice(price);
        service.addService(currentService);
        this.index();
    }

    public void update(int id, String newName, Float price) {
        Service currentService = service.getService(id);
        if (price != null) { currentService.setPrice(price); }
        if (newName != null) { currentService.setTitle(newName); }
        view.show(currentService);
    }

    public void destroy(int id) {
        service.destroyService(id);
        this.index();
    }

    
    public void saveService(Integer id) {
        Service currentService = service.getService(id);
        this.service.saveService(id);
        view.show(currentService);
    };

    public void saveServices() { this.service.saveServices(); this.index(); };
    public void loadServices() { this.service.loadServices(); this.index(); };

}
