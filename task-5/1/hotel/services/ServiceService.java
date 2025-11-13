package hotel.services;

import hotel.collections.ServicesCollection;
import hotel.models.Service;

public class ServiceService {
    private final ServicesCollection services = new ServicesCollection();

    public ServicesCollection getServices() { return this.services; }
    public void addService(Service service) { this.services.get().add(service); };

    public void destroyService(String title) {
        Service service = getService(title);
        if (service == null) return;

        this.services.get().remove(service);
    };

    public Service getService(String title) {
        Service foundService = null;
        for ( Service service : this.services.get() ) {
            if (service.getTitle().equals(title)) { foundService = service; }
        }
        return foundService;
    }
}
