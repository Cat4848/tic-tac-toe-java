package game;

import BoardRenderer.IBoardRenderer;
import UserInput.IUserInput;
import Logger.ILogger;
import BoardWinValidator.BoardWinValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
  final int size;
  final char[][] board;
  private int count = 0;
  private String[] playersNames;
  // TODO add a back command to the cli to go back one step like time travel
  private List<int[]> moves = new ArrayList<int[]>();
  private boolean isWinner = false;

  final IBoardRenderer boardRenderer;
  final IUserInput userInput;
  final ILogger logger;
  final BoardWinValidator boardWinValidator;

  public Game(int size, IBoardRenderer boardRenderer, IUserInput userInput, ILogger logger, BoardWinValidator boardWinValidator) {
    // TODO build a domain type to represent the size as an integer greater or equal to 3
    if (size < 3) {
      throw new Error("The board size must an integer number greater or equal to 3");
    }
    this.size = size;
    this.board = new char[size][size];
    for (char[] row : board) {
      Arrays.fill(row, '_');
    }
    this.boardRenderer = boardRenderer;
    this.userInput = userInput;
    this.logger = logger;
    this.boardWinValidator = boardWinValidator;
  }

  void play() {
    setPlayersNames();

    while (!isWinner) {
      if (count < 1) {
        boardRenderer.render(board);
      }
      setPlayerMove();
      boardRenderer.render(board);
      isWinner = isWinner();
      if (isWinner) {
        logger.logMessage("We have a winner: " + playersNames[count % 2]);
      }
      count++;
    }
  }

  void setPlayersNames() {
    this.playersNames = userInput.getPlayersName();
  }

  void setPlayerMove() {
    // TODO unable to set an already set cell
    if (count < 2) {
      logger.logMessage("Enter next move like this: 1,2. For first row and second column.");
    }
    logger.logMessage("It's " + playersNames[count % 2] + "'s turn...");
    int[] currMove = userInput.getPlayerMove();
    moves.add(currMove);
    board[currMove[0] - 1][currMove[1] - 1] = count % 2 == 0 ? 'X' : 'O';
  }

  void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  boolean isWinner() {
    boolean onRows = boardWinValidator.isWinnerOnRows(board);
    boolean onCol = boardWinValidator.isWinnerOnCol(board);
    boolean onDiag1 = boardWinValidator.isWinnerOnDiagonalLeftToRight(board);
    boolean onDiag2 = boardWinValidator.isWinnerOnDiagonalRightToLeft(board);
    return onRows || onCol || onDiag1 || onDiag2;
  }
}