package Logger;

public class ConsoleLogger implements ILogger {
  public void logMessage(String log) {
    System.out.println(log);
  }

  public void logWarning(String log) {
    System.out.println(log);
  }

  public void logError(String log) {
    System.out.println(log);
  }
}