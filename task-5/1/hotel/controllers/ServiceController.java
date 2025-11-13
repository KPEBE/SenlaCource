package hotel.controllers;

import hotel.enums.ServiceType;
import hotel.models.Service;
import hotel.services.HotelService;
import hotel.views.ServiceView;
import java.util.ArrayList;

public class ServiceController {

    private final ServiceView view = new ServiceView();

    public void index() {
        ArrayList<Service> services = HotelService.get().getServiceService().getServices().get();
        view.index(services);
    }

    public void show(String title) {
        Service service = HotelService.get().getServiceService().getService(title);
        view.show(service);
    }

    public void create(String title, ServiceType type, float price) {
        Service service = new Service(title, type);
        service.setPrice(price);
        HotelService.get().getServiceService().addService(service);
        this.index();
    }

    public void update(String title, String newName, Float price) {
        Service service = HotelService.get().getServiceService().getService(title);
        if (price != null) { service.setPrice(price); }
        if (newName != null) { service.setTitle(newName); }
        view.show(service);
    }

    public void destroy(String title) {
        HotelService.get().getServiceService().destroyService(title);
        this.index();
    }

}
