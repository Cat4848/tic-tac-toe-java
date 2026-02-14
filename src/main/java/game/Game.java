package game;

import java.util.Arrays;

public class Game {
  int size;
  char[][] board;

  public Game(int size) {
    // TODO build a domain type to represent the size as an integer greater or equal to 3
    if(size < 3) {
      throw new Error("The board size must an integer number greater or equal to 3");
    }
    this.size = size;
    this.board = new char[size][size];
    for(char[] row: board){
      Arrays.fill(row, '_');
    }

    renderBoard();
  }

  void renderBoard() {
    for(int i = 0; i < size; i++) {
      System.out.println("board item " + Arrays.toString(board[i]));
    }
  }
}
