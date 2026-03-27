package PlayerInputValidatorTests;

import Exceptions.InvalidPlayerMoveException;
import Exceptions.InvalidPlayerNameException;
import PlayerInputValidator.PlayerInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test suite for PlayerInputValidator class")
public class PlayerInputValidatorTests {
  String invalidPlayerMoveExceptionMessage = "Invalid player move. Cannot be zero or out of board and must have comma between coordinates.";
  String invalidPlayerNameExceptionMessage = "Invalid player name. Cannot be empty and must have between 3 and 20 characters.";

  @Test
  void ifReturnsPlayersNameCorrectly() throws InvalidPlayerNameException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    String input = "Mike and Jill";
    String name = playerInputValidator.validatePlayerName(input);
    assertEquals(input, name);
  }

  @Test
  void ifItThrowsErrorWhenPlayerNameIsEmptyString() throws InvalidPlayerNameException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerNameException exception = assertThrows(
            InvalidPlayerNameException.class,
            () -> playerInputValidator.validatePlayerName("")
    );
    assertEquals(invalidPlayerNameExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenPlayerNameIsLessThanThreeChars() throws InvalidPlayerNameException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerNameException exception = assertThrows(
            InvalidPlayerNameException.class,
            () -> playerInputValidator.validatePlayerName("Mi")
    );
    assertEquals(invalidPlayerNameExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenPlayerNameIsMoreThanTwentyChars() throws InvalidPlayerNameException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    String playerName = "A very long name for this player.";
    InvalidPlayerNameException exception = assertThrows(
            InvalidPlayerNameException.class,
            () -> playerInputValidator.validatePlayerName(playerName)
    );
    assertEquals(invalidPlayerNameExceptionMessage, exception.getMessage());
  }

  @Test
  void ifPlayerMoveValidationSucceeds() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    String input = "1,1";
    String move = playerInputValidator.validatePlayerMove(input);
    assertEquals(input, move);
  }

  @Test
  void ifItThrowsErrorWhenInvalidMoveIsProvided() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("11")
    );
    assertEquals(invalidPlayerMoveExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenMoveWithValueZeroIsProvided() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("0,1")
    );
    assertEquals(invalidPlayerMoveExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenMoveIsOutBoard() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("1,5")
    );
    assertEquals(invalidPlayerMoveExceptionMessage, exception.getMessage());
  }
}