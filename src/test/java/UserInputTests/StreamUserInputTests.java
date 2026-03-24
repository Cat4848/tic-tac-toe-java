package UserInputTests;

import PlayerInputValidator.PlayerInputValidator;
import UserInput.*;
import Logger.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;

@DisplayName("Test suite for the StreamUserInput")
public class StreamUserInputTests {
  final int boardSize = 3;
  final ILogger logger;
  final PlayerInputValidator playerInputValidator;

  public StreamUserInputTests() {
    this.logger = new ConsoleLogger();
    this.playerInputValidator = new PlayerInputValidator(boardSize);
  }

  @Test
  void ifReturnsPlayersNamesCorrectly() {
    String names = "Mike\nFrank\n";
    ByteArrayInputStream bais = new ByteArrayInputStream(names.getBytes());
    IUserInput userInput = new StreamUserInput(bais, logger, playerInputValidator);

    String[] playersNames = userInput.getPlayersName();
    String[] expected = {"Mike", "Frank"};
    assertArrayEquals(expected, playersNames);
  }

  @Test
  void ifItThrowsWhenPlayerNameIsEmptyString() {
    String names = "VeryLongNameOverTwentyCharactersLong\nRalph\nJohn\nLuke";
    ByteArrayInputStream bais = new ByteArrayInputStream(names.getBytes());
    ILogger mockedLogger = mock(ConsoleLogger.class);
    IUserInput userInput = new StreamUserInput(bais, mockedLogger, playerInputValidator);
    String[] playersNames = userInput.getPlayersName();

    verify(mockedLogger, times(2)).logMessage("Name of Player 1:");
    verify(mockedLogger, times(1)).logMessage("Name of Player 2:");
    verify(mockedLogger, times(1)).logMessage("Invalid player name. Let's try again.");

    assertEquals(2, playersNames.length);
  }

  @Test
  void ifReturnsThePlayerMoveCorrectly() {
    String moves = "1,1\n2,1";
    ByteArrayInputStream bais = new ByteArrayInputStream(moves.getBytes());
    IUserInput userInput = new StreamUserInput(bais, logger, playerInputValidator);

    int[] playerMove1 = userInput.getPlayerMove();
    int[] expected1 = new int[]{1, 1};
    assertArrayEquals(expected1, playerMove1);

    int[] playerMove2 = userInput.getPlayerMove();
    int[] expected2 = new int[]{2, 1};
    assertArrayEquals(expected2, playerMove2);
  }
}