
import java.util.ArrayList;

public class Buffer {
  public ArrayList buffer = new ArrayList();
  public Integer bufferSize;

  public Buffer(Integer bufferSize) {
    this.bufferSize = bufferSize;
  }

  public synchronized Object get() {
      while (buffer.isEmpty()) {
        try { wait(); } catch (InterruptedException e) {}
      }

      Object out = buffer.get(0);
      buffer.remove(0);
      notify();
      return out;
   }

   public synchronized void put(Object in) {
      while (buffer.size() >= bufferSize) {
         try { wait(); } catch (InterruptedException e) {} 
      }

      buffer.add(in);
      notify();
   }
}