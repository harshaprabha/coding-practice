package designPatterns.cor;

public abstract class AbstractLogger {

  public static int INFO = 1;
  public static int DEBUG = 2;
  public static int ERROR = 3;

  protected int level;

  protected AbstractLogger nextLogger;

  void setNextLogger(AbstractLogger logger) {
    this.nextLogger = logger;
  }

  public void logMessage(int level, String msg) {
    if (level <= this.level) {
      writeMessage(msg);
    }
    if (nextLogger != null) {
      nextLogger.logMessage(level, msg);
    } else {
      System.out.println("End of chain. Cannot process.");
    }

  }

  abstract protected void writeMessage(String msg);

}
