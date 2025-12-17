package hotel.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigLoader {

  public static void loadConfig(Class<?> klass) {
    if (klass.getAnnotation(AppConfig.class) == null) return;

    for (Field field : klass.getDeclaredFields()) {
      try { proccessField(field, klass); }
      catch (IllegalAccessException e) { System.out.println("Error on autoload config field: " + e.getMessage()); }
    }
  }

  private static void proccessField(Field field, Class<?> klass) throws IllegalAccessException {
    if (!field.isAnnotationPresent(ConfigProperty.class)) { return; }

    ConfigProperty property = field.getAnnotation(ConfigProperty.class);
    if (property == null) { System.out.println("Cant get annotation: " + field.getName()); return; }

    field.setAccessible(true);
    Class<?> type = field.getType();
    if (type == null) type = property.type();

    String value = loadProperty(property.configFileName(), property.propertyName());     
    var casted = castByType(type, value);
    field.set(klass, casted);
  }

  private static String loadProperty(String path, String propertyName) {
    try (FileInputStream input = new FileInputStream(path)) { 
      Properties config = new Properties();
      config.load(input);
      String value = config.getProperty(propertyName);
      return value;
    }
    catch (IOException e) { 
      System.out.println("Error on load: " + e.getMessage());
      return null;
    }
  }

  private static Object castByType(Class type, String value) {
    if (type == String.class) { return value; }
    else if (type == Integer.class || type == int.class) { return Integer.parseInt(value); }
    else if (type == Boolean.class || type == boolean.class) { return Boolean.parseBoolean(value); }
    else if (type == Float.class || type == float.class) { return Float.parseFloat(value); }
    else { return value; }
  }

}