package BoardWinValidator;

public class BoardWinValidator {
  public boolean isWinnerOnRows(char[][] board) {
    int size = board.length;
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

  public boolean isWinnerOnCol(char[][] board) {
    int size = board.length;
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

  public boolean isWinnerOnDiagonalLeftToRight(char[][] board) {
    int size = board.length;
    int first = board[0][0];
    for (int i = 1; i < size; i++) {
      if (first != board[i][i] || (first == '_' && board[i][i] == '_')) {
        return false;
      }
    }
    return true;
  }

  public boolean isWinnerOnDiagonalRightToLeft(char[][] board) {
    int size = board.length;
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