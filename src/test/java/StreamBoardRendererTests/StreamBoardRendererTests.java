package StreamBoardRendererTests;

import BoardRenderer.StreamBoardRenderer;
import Logger.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Test suite for the StreamBoardRenderer")
public class StreamBoardRendererTests {
  @Test
  void ifRendersTheBoardCorrectly() {
    ConsoleLogger logger = mock(ConsoleLogger.class);
    StreamBoardRenderer boardRenderer = new StreamBoardRenderer(logger);
    char[][] board = new char[][]{{'X', 'O', '_'}, {'_', '_', '_'}, {'O', '_', '_'}};
    boardRenderer.render(board);

    verify(logger).logMessage(Arrays.toString(board[0]));
    verify(logger).logMessage(Arrays.toString(board[1]));
    verify(logger).logMessage(Arrays.toString(board[2]));
  }
}



