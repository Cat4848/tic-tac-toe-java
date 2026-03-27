package Exceptions;

public class InvalidPlayerMoveException extends Exception {
  private String message = null;

  public InvalidPlayerMoveException() {
    super();
  }

  public InvalidPlayerMoveException(String message) {
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