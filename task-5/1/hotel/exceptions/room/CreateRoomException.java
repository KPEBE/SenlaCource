package hotel.exceptions.room;

public class CreateRoomException extends RuntimeException  {
  public CreateRoomException(String text) {
    super(String.format("Error in create room: %s", text));
  }
}