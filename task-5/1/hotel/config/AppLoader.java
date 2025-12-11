package hotel.config;

import java.util.List;

public class AppLoader {
  
  public static void load() {
    try {
      List<Class<?>> classes = ClassFinder.getClasses("hotel");
      for (Class<?> klass : classes) {
        ConfigLoader.loadConfig(klass);
        new AutoDILoader(klass).load();
      }
    }
    catch (Exception e) {
      System.err.println("Error on Load App: " + e.getMessage());
    }
  }

}