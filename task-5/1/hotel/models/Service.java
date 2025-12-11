package hotel.models;

import hotel.enums.ServiceType;
import hotel.exceptions.service.*;
import hotel.interfaces.IInspectable;
import hotel.services.HotelService;

public class Service extends Model implements IInspectable {
    private String title;
    private ServiceType type;
    private float price = 0.0f;

    public Service(Integer id) { super(id); }
    public Service(String title, ServiceType type) { 
        super(null);
        if (HotelService.get().hotel.serviceService.getServices().findByTitle(title) != null) { throw new CreateServiceException("duplicate service title"); }

        this.title = title;
        this.type = type;
    }

    public ServiceType getType() { return this.type; }
    public String getTitle() { return this.title; }
    public float getPrice() { return this.price; }

    public boolean setPrice(float newPrice) {
        if (newPrice <= 0) { throw new UpdateServiceException("price must be more then zero"); }

        this.price = newPrice;
        return true;
    }

    public void setTitle(String newTitle) { this.title = newTitle; }
    public void setType(ServiceType type) { this.type = type; }

    @Override
    public String toString() {
        return String.format("<Service#%s title: %s price: %s type: %s>", this.getID(), this.title, this.getPrice(), this.type);
    }
}