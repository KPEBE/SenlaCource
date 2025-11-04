package hotel.services;

import hotel.collections.ServicesCollection;
import hotel.models.Service;

public class ServiceService {
    private final ServicesCollection services = new ServicesCollection();

    public ServicesCollection GetServices() { return this.services; }
    public void AddService(Service service) { this.services.Get().add(service); };
}
