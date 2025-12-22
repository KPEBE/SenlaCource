public class ThreadNames {
  private static final Object lock = new Object();

  public static void main(String[] args) {
    Thread firstThread = new NamedThread("First Thread", 0, lock);
    Thread secondThread = new NamedThread("Second Thread", 1, lock);

    firstThread.start();
    secondThread.start();
  }
}