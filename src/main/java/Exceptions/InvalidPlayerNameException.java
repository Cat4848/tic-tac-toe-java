package Exceptions;

public class InvalidPlayerNameException extends Exception {
  private String message = null;

  public InvalidPlayerNameException() {
    super();
  }

  public InvalidPlayerNameException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}