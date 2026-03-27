package PlayerInputValidatorTests;

import Exceptions.InvalidPlayerMoveException;
import PlayerInputValidator.PlayerInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test suite for PlayerInputValidator class")
public class PlayerInputValidatorTests {
  String invalidPlayerExceptionMessage = "Invalid player move.";

  @Test
  void ifReturnsPlayersNameCorrectly() {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
  }

  @Test
  void ifItValidatesInvalidPlayerName() {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
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
    assertEquals(invalidPlayerExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenMoveWithValueZeroIsProvided() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("0,1")
    );
    assertEquals(invalidPlayerExceptionMessage, exception.getMessage());
  }

  @Test
  void ifItThrowsErrorWhenMoveIsOutBoard() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("1,5")
    );
    assertEquals(invalidPlayerExceptionMessage, exception.getMessage());
  }
}