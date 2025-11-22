package hotel.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
  private static final Map<Class<?>, Integer> autoIncrements = new HashMap<>();
  private final Integer id;
  private final Class<?> modelClass = this.getClass();

  public Model(Integer id) {
    if (id == null) { id = nextID(); }
    else updateID(id);
    this.id = id;
  }
  
  public Integer getID() { return this.id; };

  private Integer nextID() { 
    Integer ID = autoIncrements.getOrDefault(modelClass, 1);
    autoIncrements.put(modelClass, ID + 1);
    return ID;
  };

  private Integer updateID(Integer id) { 
    Integer ID = autoIncrements.getOrDefault(modelClass, 1);
    if (id >= ID) { autoIncrements.put(modelClass, id + 1); }
    return ID;
  };
}