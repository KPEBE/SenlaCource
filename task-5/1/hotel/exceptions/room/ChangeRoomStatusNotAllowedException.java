package hotel.exceptions.room;

public class ChangeRoomStatusNotAllowedException extends RuntimeException  {
  public ChangeRoomStatusNotAllowedException() {
    super(String.format("Change room status is not allowed in application"));
  }
}