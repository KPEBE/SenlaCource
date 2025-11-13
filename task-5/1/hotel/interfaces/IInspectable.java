package hotel.interfaces;

public interface IInspectable {
    default public void inspect() { System.out.println(this.toString()); };
}