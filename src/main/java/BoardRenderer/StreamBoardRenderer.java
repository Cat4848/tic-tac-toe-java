package BoardRenderer;

import java.io.PrintStream;
import java.util.Arrays;

public class StreamBoardRenderer implements IBoardRenderer {
  final PrintStream out;
  public StreamBoardRenderer(PrintStream out) {
    this.out = out;
  }

  public void render(char[][] board) {
    for(char[] row: board) {
      out.println(Arrays.toString(row));
    }
  }
}