package lld.logger;

public interface Logger {

  void start(String processId);

  void stop(String processId);

  void poll();

}
