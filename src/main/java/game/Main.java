package game;

import BoardRenderer.*;
import UserInput.*;
import Logger.*;

public class Main {
  static void main(String[] args) {
    // TODO add dynamic board selectable by the user
    ILogger logger = new ConsoleLogger();
    IBoardRenderer boardRenderer = new StreamBoardRenderer(logger);
    IUserInput userInput = new StreamUserInput(System.in, logger);
    Game board = new Game(3, boardRenderer, userInput);
    board.play();
  }
}
