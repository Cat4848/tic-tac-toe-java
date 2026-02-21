package game;

import BoardRenderer.IBoardRenderer;
import UserInput.IUserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
  final int size;
  final char[][] board;
  private int count = 0;
  final Scanner reader = new Scanner(System.in);
  private String[] playersNames;
  // TODO add a back command to the cli to go back one step like time travel
  private List<int[]> moves = new ArrayList<int[]>();
  private boolean isWinner = false;

  IBoardRenderer boardRenderer;
  IUserInput userInput;

  public Game(int size, IBoardRenderer boardRenderer, IUserInput userInput) {
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
        System.out.println("We have a winner: " + playersNames[count % 2]);
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
      System.out.println("Enter next move like this: 1,2. For first row and second column.");
    }
    System.out.println("It's " + playersNames[count % 2] + "'s turn...");
    int[] currMove = userInput.getPlayerMove();
    moves.add(currMove);
    board[currMove[0] - 1][currMove[1] - 1] = count % 2 == 0 ? 'X' : 'O';
  }

  void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  boolean isWinner() {
    boolean onRows = isWinnerOnRows();
    boolean onCol = isWinnerOnCol();
    boolean onDiag1 = isWinnerOnDiagonalLeftToRight();
    boolean onDiag2 = isWinnerOnDiagonalRightToLeft();
    return onRows || onCol || onDiag1 || onDiag2;
  }

  boolean isWinnerOnRows() {
    boolean[] res = new boolean[size];
    for (int i = 0; i < size; i++) {
      int first = board[i][0];
      boolean isWinnerRow = true;
      for (int j = 1; j < size; j++) {
        if (first != board[i][j] || (first == '_' && board[i][j] == '_')) {
          isWinnerRow = false;
          break;
        }
      }
      res[i] = isWinnerRow;
    }
    for (int i = 0; i < size; i++) {
      if (res[i]) {
        return true;
      }
    }
    return false;
  }

  boolean isWinnerOnCol() {
    boolean[] res = new boolean[size];
    for (int i = 0; i < size; i++) {
      boolean isWinnerCol = true;
      int first = board[0][i];
      for (int j = 1; j < size; j++) {
        if (first != board[j][i] || (first == '_' && board[j][i] == '_')) {
          isWinnerCol = false;
          break;
        }
      }
      res[i] = isWinnerCol;
    }
    for (int i = 0; i < size; i++) {
      if (res[i]) {
        return true;
      }
    }
    return false;
  }

  boolean isWinnerOnDiagonalLeftToRight() {
    int first = board[0][0];
    for (int i = 1; i < size; i++) {
      if (first != board[i][i] || (first == '_' && board[i][i] == '_')) {
        return false;
      }
    }
    return true;
  }

  boolean isWinnerOnDiagonalRightToLeft() {
    int first = board[0][size - 1];
    int j = size - 2;
    for (int i = 1; i < size; i++) {
      if (first != board[i][j] || (first == '_' && board[i][j] == '_')) {
        return false;
      }
      j--;
    }
    return true;
  }
}
