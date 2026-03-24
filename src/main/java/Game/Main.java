package Game;

import BoardRenderer.*;
import PlayerInputValidator.PlayerInputValidator;
import UserInput.IUserInput;
import UserInput.StreamUserInput;
import Logger.*;
import BoardWinValidator.BoardWinValidator;

public class Main {
  static void main(String[] args) {
    // TODO add dynamic board selectable by the user
    int boardSize = 3;

    ILogger logger = new ConsoleLogger();

    PlayerInputValidator playerInputValidator = new PlayerInputValidator(boardSize);
    IUserInput userInput = new StreamUserInput(System.in, logger, playerInputValidator);

    BoardWinValidator boardWinValidator = new BoardWinValidator();

    IBoardRenderer boardRenderer = new StreamBoardRenderer(logger);

    Game game = new Game(boardSize, boardRenderer, userInput, logger, boardWinValidator);
    game.play();
  }
}
