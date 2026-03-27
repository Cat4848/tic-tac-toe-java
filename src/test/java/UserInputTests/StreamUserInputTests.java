package UserInputTests;

import PlayerInputValidator.PlayerInputValidator;
import UserInput.*;
import Logger.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

@DisplayName("Test suite for the StreamUserInput")
public class StreamUserInputTests {
  final int boardSize = 3;
  final ILogger logger;
  final PlayerInputValidator playerInputValidator;

  @Mock ByteArrayInputStream baisa;

  public StreamUserInputTests() {
    this.logger = new ConsoleLogger();
    this.playerInputValidator = new PlayerInputValidator(boardSize);
  }
}