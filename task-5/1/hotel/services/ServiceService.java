package hotel.services;

import hotel.collections.ServicesCollection;
import hotel.models.Service;
import hotel.storages.ServicesStorage;

public class ServiceService {
    private final ServicesCollection services = new ServicesCollection();
    private final ServicesStorage storage = new ServicesStorage(this);

    public ServicesCollection getServices() { return this.services; }
    public void addService(Service service) { this.services.get().add(service); };

    public void destroyService(Integer id) {
        Service service = getService(id);
        if (service == null) return;

        this.services.get().remove(service);
    };

    public Service getService(Integer id) { return services.find(id); }

    public void saveService(Integer id) { this.storage.saveService(getService(id)); };
    public void saveServices() { this.storage.saveServices(); };
    public void loadServices() { this.storage.loadServices(); };
}
