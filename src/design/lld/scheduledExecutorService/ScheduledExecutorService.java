package lld.scheduledExecutorService;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public interface ScheduledExecutorService {
    public void  schedule(Runnable command, long delay, TimeUnit unit);
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
