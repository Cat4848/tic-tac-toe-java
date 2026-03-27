package PlayerInputValidatorTests;

import Exceptions.InvalidPlayerMoveException;
import Logger.ConsoleLogger;
import Logger.ILogger;
import PlayerInputValidator.PlayerInputValidator;
import UserInput.IUserInput;
import UserInput.StreamUserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Test suite for PlayerInputValidator class")
public class PlayerInputValidatorTests {
  @Test
  void ifReturnsPlayersNameCorrectly() {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
  }

  @Test
  void ifItValidatesInvalidPlayerName() {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
  }

  @Test
  void ifReturnsThePlayerMoveCorrectly() {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
  }
  @Test
  void ifItThrowsErrorWhenInvalidMoveIsProvided() throws InvalidPlayerMoveException {
    PlayerInputValidator playerInputValidator = new PlayerInputValidator(3);
    InvalidPlayerMoveException exception = assertThrows(
            InvalidPlayerMoveException.class,
            () -> playerInputValidator.validatePlayerMove("11")
    );
    assertEquals("Invalid player move.", exception.getMessage());
  }
}