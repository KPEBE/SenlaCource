package hotel.lib;

public class AutoConfig {
  private static AutoConfig config;

  public static AutoConfig GetConfig() {
    if (config == null) { config = new AutoConfig(); }
    return config;
  } 

  @ConfigProperty(propertyName="Room.canChangeRoomStatus")
  public boolean canChangeRoomStatus;

  @ConfigProperty(propertyName="Room.maxRoomClientsLog")
  public int maxRoomClientsLog;
}