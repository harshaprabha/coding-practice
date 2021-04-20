package designPatterns.cor;

public class FileLogger extends AbstractLogger {

  public FileLogger(int level) {
    this.level = level;
  }

  @Override
  void setNextLogger(AbstractLogger logger) {
    super.setNextLogger(logger);
  }

  @Override
  protected void writeMessage(String msg) {
    System.out.println("File logger logging =" + msg);
  }
}
