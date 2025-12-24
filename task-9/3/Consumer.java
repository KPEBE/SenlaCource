public class Consumer implements Runnable{
  private final Buffer buffer;

  public Consumer(Buffer buffer){
    this.buffer = buffer; 
  }

  @Override
  public void run() {
    while (true) {
      Object obj = buffer.get();
      System.out.printf("Consumed: %s\n", obj);
      sleep(1500);
    }
  }

  private void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}