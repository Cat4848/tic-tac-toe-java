package game;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
  int size;
  char[][] board;
  int count = 0;
  Scanner reader = new Scanner(System.in);
  String player1;
  String player2;

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
  }

  void play() {
    setPlayersNames();
    
    while(count < 10) {
      renderBoard();

    }

  }

  void renderBoard() {
    for(char[] row: board) {
      System.out.println("board item " + Arrays.toString(row));
    }
  }

  void setPlayersNames() {
    String[] names = getPlayerNames();
    this.player1 = names[0];
    this.player2 = names[1];
  }

  String[] getPlayerNames() {
    System.out.println("Name of Player 1:");
    String p1Name = reader.nextLine();
    System.out.println("Name of Player 2:");
    String p2Name = reader.nextLine();
    return new String[]{p1Name, p2Name};
  }

  String getPlayerInput() {

  }

}
