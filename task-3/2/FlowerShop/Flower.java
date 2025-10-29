package FlowerShop;

public abstract class Flower {
    public abstract String GetName();
    public abstract float GetPrice();

    public static class Rose extends Flower {
        public String GetName() { return "Rose"; }
        public float GetPrice() { return 98.5f; }
    }

    public static class Sunflower extends Flower {
        public String GetName() { return "Sunflower"; }
        public float GetPrice() { return 30f; }
    }

    public static class Tulip extends Flower {
        public String GetName() { return "Tulip"; }
        public float GetPrice() { return 25.7f; }
    }

    public static class Peony extends Flower {
        public String GetName() { return "Peony"; }
        public float GetPrice() { return 145.45f; }
    }

    public static class Lily extends Flower {
        public String GetName() { return "Lily"; }
        public float GetPrice() { return 83.99f; }
    }
}
