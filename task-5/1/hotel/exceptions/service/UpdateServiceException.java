package hotel.exceptions.service;

public class UpdateServiceException extends RuntimeException  {
  public UpdateServiceException(String text) {
    super(String.format("Error in update service: %s", text));
  }
}