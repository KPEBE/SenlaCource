package hotel.exceptions.room;

public class UpdateRoomException extends RuntimeException  {
  public UpdateRoomException(String text) {
    super(String.format("Error in update room: %s", text));
  }
}