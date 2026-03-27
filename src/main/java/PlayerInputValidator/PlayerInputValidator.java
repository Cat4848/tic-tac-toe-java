package PlayerInputValidator;

import Exceptions.InvalidPlayerMoveException;
import Exceptions.InvalidPlayerNameException;
import java.util.regex.Pattern;

public class PlayerInputValidator {
  final int boardSize;

  public PlayerInputValidator(int boardSize) {
    this.boardSize = boardSize;
  }

  public String validatePlayerName(String name) throws InvalidPlayerNameException {
    if (name == null) {
      throw new InvalidPlayerNameException("The name cannot be null");
    }
    if (name.isEmpty()) {
      throw new InvalidPlayerNameException("The name cannot be empty.");
    }
    if (name.length() > 20) {
      throw new InvalidPlayerNameException("The name is too long. Max 20 characters.");
    }
    return name;
  }

  public String validatePlayerMove(String input) throws InvalidPlayerMoveException {
    String regexp = "^[1-" + boardSize + "]+,[1-" + boardSize + "]+$";
    if (!Pattern.matches(regexp, input)) {
      throw new InvalidPlayerMoveException("Invalid player move.");
    }
    return input;
  }
}