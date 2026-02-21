package game;

import BoardRenderer.*;
import UserInput.*;
import Logger.*;
import BoardWinValidator.BoardWinValidator;

public class Main {
  static void main(String[] args) {
    // TODO add dynamic board selectable by the user
    ILogger logger = new ConsoleLogger();
    IBoardRenderer boardRenderer = new StreamBoardRenderer(logger);
    IUserInput userInput = new StreamUserInput(System.in, logger);
    BoardWinValidator boardWinValidator = new BoardWinValidator();

    Game game = new Game(3, boardRenderer, userInput, logger, boardWinValidator);
    game.play();
  }
}
