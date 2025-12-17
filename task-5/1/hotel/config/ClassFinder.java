package hotel.config;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class ClassFinder {
  private static final HashMap<String, List<Class<?>>> cachedClasses = new HashMap<>();

  public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
    List<Class<?>> cached = cachedClasses.get(packageName);
    if (cached != null && !cached.isEmpty()) return cached;

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = classLoader.getResources(path);
    
    List<File> dirs = new ArrayList<>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      dirs.add(new File(resource.getFile()));
    }

    cached = new ArrayList<>();
    cachedClasses.put(packageName, cached);

    for (File directory : dirs) { cached.addAll(findClasses(directory, packageName)); }
    
    return cached;
  }
    
  private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
    List<Class<?>> classes = new ArrayList<>();
    if (!directory.exists()) return classes;
    
    File[] files = directory.listFiles();
    if (files == null) return classes;
    
    for (File file : files) {
      if (file.isDirectory()) { classes.addAll(findClasses(file, packageName + "." + file.getName())); } 
      else if (file.getName().endsWith(".class")) {
        String className = file.getName().substring(0, file.getName().length() - 6);
        String fullClassName = packageName + '.' + className;
        Class<?> klass = Class.forName(fullClassName);
        classes.add(klass);
      }
    }
    
    return classes;
  }
} 