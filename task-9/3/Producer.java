
import java.util.Random;

public class Producer implements Runnable{
  private final Buffer buffer;

  public Producer(Buffer buffer){
    this.buffer = buffer; 
  }

  @Override
  public void run() {
    while (true) {
      int randomNumber = generateRangom();
      System.out.printf("Produced: %s\n", randomNumber);
      buffer.put(randomNumber);
      sleep(1000);
    }
  }

  private int generateRangom() {
    int randomMin = 100;
    int randomMax = 999;

    int randomNumber = new Random().nextInt(randomMax - randomMin + 1) + randomMin;
    return randomNumber;
  }

  private void sleep(int time) {
    try { Thread.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}