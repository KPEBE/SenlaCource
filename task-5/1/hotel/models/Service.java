package hotel.models;

import hotel.enums.ServiceType;
import hotel.interfaces.IInspectable;

public class Service implements IInspectable {
    private String title;
    private final ServiceType type;
    private float price = 0.0f;

    public Service(String title, ServiceType type) { this.title = title; this.type = type; }

    public ServiceType getType() { return this.type; }
    public String getTitle() { return this.title; }
    public float getPrice() { return this.price; }

    public boolean setPrice(float newPrice) {
        if (newPrice <= 0) { return false; }

        this.price = newPrice;
        return true;
    }

    public void setTitle(String newTitle) { this.title = newTitle; }

    @Override
    public String toString() {
        return String.format("<Service#%s price: %s type: %s>", this.title, this.getPrice(), this.type);
    }
}