package hotel.config;

import hotel.services.HotelService;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    private static final String DATA_PATH = "./resources/hotel.data";

    public static void saveHotel() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_PATH))) { out.writeObject(HotelService.get()); }
        catch (IOException e) { System.err.println("Error on serialize: " + e.getMessage()); }
    }

    public static HotelService loadHotel() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_PATH))) { return (HotelService) in.readObject(); }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error on deserialize: " + e.getMessage());
            return new HotelService();
        }
    }

}