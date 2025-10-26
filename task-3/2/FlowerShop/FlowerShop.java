package FlowerShop;

public class FlowerShop {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        bouquet.AddFlower(new Flower.Rose());
        bouquet.AddFlower(new Flower.Rose());
        bouquet.AddFlower(new Flower.Rose());
        bouquet.AddFlower(new Flower.Lily());
        bouquet.AddFlower(new Flower.Lily());
        bouquet.AddFlower(new Flower.Tulip());
        bouquet.AddFlower(new Flower.Peony());

        bouquet.ShowFlowers();
        System.out.printf("Price of bouquet: %s\n", bouquet.GetPrice());
    }
}