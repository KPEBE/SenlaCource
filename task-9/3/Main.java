public class Main {
  public static void main(String[] args) {
    Buffer buffer = new Buffer(1);
    Producer producer = new Producer(buffer);
    Consumer consumer = new Consumer(buffer);

    new Thread(producer).start();
    new Thread(consumer).start();
  }
}