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
//    String regexp = "^\\w{3,20}$";
    String regexp = "^[\\w|\\s]{3,20}$";
    if (!Pattern.matches(regexp, name)) {
      throw new InvalidPlayerNameException("Invalid player name. Cannot be empty and must have between 3 and 20 characters.");
    }
    return name;
  }

  public String validatePlayerMove(String input) throws InvalidPlayerMoveException {
    String regexp = "^[1-" + boardSize + "]+,[1-" + boardSize + "]+$";
    if (!Pattern.matches(regexp, input)) {
      throw new InvalidPlayerMoveException("Invalid player move. Cannot be zero or out of board and must have comma between coordinates.");
    }
    return input;
  }
}