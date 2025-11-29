package hotel.services;

import hotel.collections.ServicesCollection;
import hotel.models.Service;
import hotel.storages.ServicesStorage;
import java.io.Serializable;

public class ServiceService implements Serializable {
    private final ServicesCollection services = new ServicesCollection();
    private transient ServicesStorage storage;

    public ServicesStorage getStorage() { 
        if (storage == null) { storage = new ServicesStorage(this); }
        return storage;
    }

    public ServicesCollection getServices() { return this.services; }
    public void addService(Service service) { this.services.get().add(service); };

    public void destroyService(Integer id) {
        Service service = getService(id);
        if (service == null) return;

        this.services.get().remove(service);
    };

    public Service getService(Integer id) { return services.find(id); }

    public void saveService(Integer id) { getStorage().saveService(getService(id)); };
    public void saveServices() { getStorage().saveServices(); };
    public void loadServices() { getStorage().loadServices(); };
}
