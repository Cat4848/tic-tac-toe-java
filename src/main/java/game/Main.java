package game;

import BoardRenderer.IBoardRenderer;
import BoardRenderer.StreamBoardRenderer;

public class Main {
  static void main(String[] args) {
    // TODO add dynamic board selectable by the user
    IBoardRenderer boardRenderer = new StreamBoardRenderer(System.out);
    Game board = new Game(3, boardRenderer);
    board.play();
  }
}
