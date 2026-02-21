package UserInput;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StreamUserInput implements IUserInput {
  final Scanner reader;
  final PrintStream out;

  public StreamUserInput(InputStream in, PrintStream out) {
    this.reader = new Scanner(in);
    this.out = out;
  }

  public String[] getPlayersName() {
    // TODO validate player's name. Can't be empty string
    out.println("Name of Player 1:");
    String p1Name = reader.nextLine();
    out.println("Name of Player 2:");
    String p2Name = reader.nextLine();
    return new String[]{p1Name, p2Name};
  }

  public int[] getPlayerMove() {
    // TODO validate the input to match x,y style, no greater than the board size
    String input = reader.nextLine();
    String[] coordinates = input.split(",");
    int row = Integer.parseInt(coordinates[0]);
    int col = Integer.parseInt(coordinates[1]);
    return new int[]{row, col};
  }
}