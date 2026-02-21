package game;

import BoardRenderer.*;
import UserInput.*;

public class Main {
  static void main(String[] args) {
    // TODO add dynamic board selectable by the user
    IBoardRenderer boardRenderer = new StreamBoardRenderer(System.out);
    IUserInput userInput = new StreamUserInput(System.in, System.out);
    Game board = new Game(3, boardRenderer, userInput);
    board.play();
  }
}
