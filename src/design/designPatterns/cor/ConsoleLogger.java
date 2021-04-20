package designPatterns.cor;

public class ConsoleLogger extends AbstractLogger {

  public ConsoleLogger(int level) {
    this.level = level;
  }

  @Override
  void setNextLogger(AbstractLogger logger) {
    super.setNextLogger(logger);
  }

  @Override
  protected void writeMessage(String msg) {
    System.out.println("Console logging =" + msg);
  }
}
