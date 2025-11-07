package hotel.models;

import hotel.interfaces.IInspectable;
import hotel.lib.PurchasableObject;
import hotel.enums.ServiceType;

public class Service extends PurchasableObject implements IInspectable {
    private String title;
    private ServiceType type;

    public Service(String title, ServiceType type) { this.title = title; this.type = type; }
    public Service(String title, ServiceType type, float price) { this.title = title; this.type = type; this.SetPrice(price); }

    public ServiceType GetType() { return this.type; }

    public void Inspect() {
        System.out.printf("<Service#%s price: %s type: %s>\n", this.title, this.GetPrice(), this.type);
    }
}