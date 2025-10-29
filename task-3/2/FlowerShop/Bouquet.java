package FlowerShop;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers = new ArrayList<Flower>();

    public void AddFlower(Flower flower) { this.flowers.add(flower); }

    public float GetPrice() {
        float price = 0f;

        for (Flower flower : this.flowers) {
            price += flower.GetPrice();
        }

        return price;
    }

    public void ShowFlowers() {
        System.out.printf("Bouquet of %d flowers:\n", this.flowers.size());
        for (Flower flower : flowers) {
            System.out.printf("- %s\n", flower.GetName());
        }
    }
}