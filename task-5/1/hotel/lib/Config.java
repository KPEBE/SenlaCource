package hotel.lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
  private static final String CONFIG_PATH = "config.properties";
  private static final Properties config = new Properties();

  public static void saveConfig() {
      try (FileOutputStream output = new FileOutputStream(CONFIG_PATH)) { config.store(output, "Hotel Configuration"); }
      catch (IOException e) { System.out.println("Error on save: " + e.getMessage()); }
  }

  public static void loadConfig() {
    try (FileInputStream input = new FileInputStream(CONFIG_PATH)) { config.load(input); }
    catch (IOException e) { System.out.println("Error on load: " + e.getMessage()); }
  }

  public static boolean canChangeRoomStatus() {
    String value = config.getProperty("can_change_room_status");
    if (value == null) { return true; }

    return (value).equals("1");
  }

  public static int maxRoomClientsLog() {
    String value = config.getProperty("max_room_clients_log");
    if (value == null) { return 3; }

    return Integer.parseInt(config.getProperty("max_room_clients_log"));
  }

}