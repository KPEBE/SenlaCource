import java.time.LocalDateTime;

public class TimerThread extends Thread {

  private Integer interval;

  public TimerThread(Integer interval) {
    super();
    setDaemon(true);
    this.interval = interval;
  }

  @Override
  public void run() {
    while (true) { 
      System.out.println("System time: " + LocalDateTime.now());
      sleep(this.interval * 1000);
    }
  }

  private void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}