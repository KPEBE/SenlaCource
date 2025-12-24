public class Timer {
  public static void main(String[] args) throws InterruptedException {
    TimerThread timer = new TimerThread(5);
    timer.start();

    while (true) { 
      System.out.println("Some work...");
      Thread.sleep(1000);
    }
  }
}