package UserInputTests;

import PlayerInputValidator.PlayerInputValidator;
import UserInput.*;
import Logger.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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