package hotel.storages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Storage {
  protected final String DATA_DIR = "./data";
  
  protected void loadFromCSV(String filePath, Consumer<String[]> loader) {
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
    {
      String line;
      while((line = reader.readLine()) != null){
          line = line.trim();
          if (line.isEmpty()) { continue; }

          String[] params = line.split(",", -1);
          params = Arrays.stream(params).map(String::trim).toArray(String[]::new);
          loader.accept(params);
      }
    }
    catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }

  protected void saveToCSV(String filePath, Object[] params) {
    createFile(filePath);
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)))
    {
      String[] stringlifies = Arrays.stream(params).map(obj -> obj != null ? obj.toString() : "").map(String::trim).toArray(String[]::new);
      String csvString = String.join(",", stringlifies);

      writer.write(String.format("%s\n", csvString));
    }
    catch(IOException ex){
        System.out.println(ex.getMessage());
    }
  }

  protected void createFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) return;

    try { file.createNewFile(); }
    catch(IOException ex) { System.out.println(ex.getMessage()); }  
  }

  protected void deleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) file.delete();
  }

  protected void recreateFile(String filePath) { deleteFile(filePath);  createFile(filePath); }
}