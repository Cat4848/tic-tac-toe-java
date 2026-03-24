package PlayerInputValidator;

import Exceptions.InvalidPlayerNameException;

public class PlayerInputValidator {
  final int boardSize;

  public PlayerInputValidator(int boardSize) {
    this.boardSize = boardSize;
  }

  public String validatePlayerName(String name) throws InvalidPlayerNameException {
    if (name.isEmpty()) {
      throw new InvalidPlayerNameException("The name cannot be empty.");
    }
    if (name.length() > 20) {
      throw new InvalidPlayerNameException("The name is too long. Max 20 characters.");
    }
    return name;
  }
}