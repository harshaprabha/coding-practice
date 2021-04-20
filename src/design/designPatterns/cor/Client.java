package designPatterns.cor;

public class Client {

  private AbstractLogger logger;

  public Client(AbstractLogger logger) {
    this.logger = logger;
  }

  public static void main(String[] args) {
    AbstractLogger fileLogger = new FileLogger(AbstractLogger.INFO);
    AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

    fileLogger.setNextLogger(consoleLogger);
    consoleLogger.setNextLogger(null);

    // fileLogger is starting
    fileLogger.logMessage(1,"harsha");

  }
}
