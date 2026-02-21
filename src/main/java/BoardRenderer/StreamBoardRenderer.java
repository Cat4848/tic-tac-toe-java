package BoardRenderer;

import java.util.Arrays;
import Logger.*;

public class StreamBoardRenderer implements IBoardRenderer {
  final ILogger logger;
  public StreamBoardRenderer(ILogger logger) {
    this.logger = logger;
  }

  public void render(char[][] board) {
    for(char[] row: board) {
      logger.logMessage(Arrays.toString(row));
    }
  }
}