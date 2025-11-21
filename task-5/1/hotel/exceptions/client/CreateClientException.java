package hotel.exceptions.client;

public class CreateClientException extends RuntimeException  {
  public CreateClientException(String text) {
    super(String.format("Error in create client: %s", text));
  }
}