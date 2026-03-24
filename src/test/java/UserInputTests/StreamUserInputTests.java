package UserInputTests;

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
  final ILogger logger;

  public StreamUserInputTests() {
    this.logger = new ConsoleLogger();
  }

  @Test
  void ifReturnsPlayersNames() {
    String names = "Mike\nFrank\n";
    ByteArrayInputStream bais = new ByteArrayInputStream(names.getBytes());
    IUserInput userInput = new StreamUserInput(bais, logger);

    String[] playersNames = userInput.getPlayersName();
    String[] expected = {"Mike", "Frank"};
    assertArrayEquals(expected, playersNames);
  }
}