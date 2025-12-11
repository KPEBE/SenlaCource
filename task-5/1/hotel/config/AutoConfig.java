package hotel.config;

@AppConfig
public class AutoConfig {

  @ConfigProperty(propertyName="Room.canChangeRoomStatus")
  public static boolean canChangeRoomStatus;

  @ConfigProperty(propertyName="Room.maxRoomClientsLog")
  public static int maxRoomClientsLog;

}