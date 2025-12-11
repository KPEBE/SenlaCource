package hotel.config;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public class AutoDILoader {
  private static HashMap<Class<?>, Object> instances =  new HashMap();

  private ArrayList<Object> recursive = new ArrayList();
  private Object object;
  private Class<?> klass;

  public AutoDILoader(Object object) {
    this.object = object;
    this.klass = object.getClass();
  }

  public AutoDILoader(Class<?> klass) {
    this.object = klass;
    this.klass = klass;
  }

  public void load() {
    for (Field field : klass.getDeclaredFields()) {
      try { proccessField(field); }
      catch (Throwable e) { System.out.println("Error on apply autoDI: " + e.getMessage()); }
    }

    for (Object instance : recursive) { new AutoDILoader(instance).load(); }
  }

  private void proccessField(Field field) throws IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    if (!field.isAnnotationPresent(AutoDI.class)) return;
    if (object == klass && !Modifier.isStatic(field.getModifiers())) return;
    field.setAccessible(true);

    AutoDI annotation = field.getAnnotation(AutoDI.class);

    Class<?> type = field.getType();
    Object instance = null;
    boolean presence = false;

    if (annotation.usePresent()) { instance = AutoDILoader.instances.get(type); presence = true; }
    if (instance == null) { instance = type.getDeclaredConstructor().newInstance(); presence = false; }

    field.set(this.object, instance);

    if (!AutoDILoader.instances.containsKey(type)) AutoDILoader.instances.put(type, instance);
    if (annotation.recursive() && !presence) this.recursive.add(instance);
  }

}