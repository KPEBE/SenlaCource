
public class NamedThread extends Thread {

  private final Object lock;
  private final Integer order;

  public NamedThread(String name, Integer order, Object lock) {
    super();
    setName(name);
    this.lock = lock;
    this.order = order;
  }

  @Override
  public void run() {
    sleep(order * 100);
    while (true) { 
      synchronized (lock) { printThreadName(); }
      sleep(1000);
    }
  }

  public void printThreadName() {
    System.out.println("Thread name: " + Thread.currentThread().getName());
  }

  private void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}