package hotel.exceptions.service;

public class CreateServiceException extends RuntimeException  {
  public CreateServiceException(String text) {
    super(String.format("Error in create service: %s", text));
  }
}