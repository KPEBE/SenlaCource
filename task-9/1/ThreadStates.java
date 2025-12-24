public class ThreadStates {
  private static final Object lock = new Object();

  public static void main(String[] args) {
    Thread waitingThread = new Thread(() -> { synchronized (lock) { waitObject(lock); } });
    Thread sleepingThread = new Thread(() -> { synchronized (lock) { sleepSeconds(5); } });
    Thread blockedThread = new Thread(() -> { synchronized (lock) { sleepSeconds(5); } });

    printThreadStatus(waitingThread);
    waitingThread.start();
    printThreadStatus(waitingThread);
    sleepSeconds(1);
    printThreadStatus(waitingThread);
    synchronized (lock) { lock.notifyAll(); }

    sleepingThread.start();
    sleepSeconds(1);
    printThreadStatus(sleepingThread);


    blockedThread.start();
    sleepSeconds(1);
    printThreadStatus(blockedThread);

    sleepSeconds(1);
    printThreadStatus(waitingThread);
  }

  public static void printThreadStatus(Thread thread) {
    System.out.println("Thread status: " + thread.getState());
  }

  public static void sleepSeconds(int time) {
    try { Thread.sleep(time * 1000); } catch (InterruptedException e) { e.printStackTrace(); }
  }

  public static void waitObject(Object object) {
    try { object.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
  }
}