package hotel.lib;

public class PurchasableObject {
    private float price = 0.0f;

    public float GetPrice() { return this.price; }

    public boolean SetPrice(float newPrice) {
        if (newPrice <= 0) { return false; }

        this.price = newPrice;
        return true;
    }
}