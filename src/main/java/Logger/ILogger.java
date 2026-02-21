package Logger;

public interface ILogger {
  void logMessage(String log);
  void logWarning(String log);
  void logError(String log);
}