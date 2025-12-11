package hotel.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigLoader {

  public static void LoadConfig(Object object) {
    var klass = object.getClass();

    for (Field field : klass.getDeclaredFields()) {
      try { ProccessField(field, object); }
      catch (IllegalAccessException e) { System.out.println("Error on autoload config field: " + e.getMessage()); }
    }
  }

  private static void ProccessField(Field field, Object object) throws IllegalAccessException {
    if (!field.isAnnotationPresent(ConfigProperty.class)) { return; }

    ConfigProperty property = field.getAnnotation(ConfigProperty.class);
    if (property == null) { System.out.println("Cant get annotation: " + field.getName()); return; }

    field.setAccessible(true);
    Class<?> type = field.getType();
    if (type == null) type = property.type();

    String value = LoadProperty(property.configFileName(), property.propertyName());     
    var casted = CastByType(type, value);
    field.set(object, casted);
  }

  private static String LoadProperty(String path, String propertyName) {
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

  private static Object CastByType(Class type, String value) {
    if (type == String.class) { return value; }
    else if (type == Integer.class || type == int.class) { return Integer.parseInt(value); }
    else if (type == Boolean.class || type == boolean.class) { return Boolean.parseBoolean(value); }
    else if (type == Float.class || type == float.class) { return Float.parseFloat(value); }
    else { return value; }
  }

}