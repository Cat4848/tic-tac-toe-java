package UserInput;

import java.io.InputStream;
import java.util.Scanner;

import Logger.ILogger;
import Exceptions.InvalidPlayerNameException;
import PlayerInputValidator.PlayerInputValidator;

public class StreamUserInput implements IUserInput {
  final Scanner reader;
  final ILogger logger;
  final PlayerInputValidator validator;

  public StreamUserInput(InputStream in, ILogger logger, PlayerInputValidator validator) {
    this.reader = new Scanner(in);
    this.logger = logger;
    this.validator = validator;
  }

  public String[] getPlayersName() {
    String[] playerNames = new String[2];
    try {
      logger.logMessage("Name of Player 1:");
      String p1Name = validator.validatePlayerName(reader.nextLine());
      playerNames[0] = p1Name;

      logger.logMessage("Name of Player 2:");
      String p2Name = validator.validatePlayerName(reader.nextLine());
      playerNames[1] = p2Name;

    } catch (InvalidPlayerNameException e) {
      logger.logMessage("Invalid player name. Let's try again.");
      getPlayersName();
    }
    return playerNames;
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