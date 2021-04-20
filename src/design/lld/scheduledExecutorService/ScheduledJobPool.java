package lld.scheduledExecutorService;


import java.util.Optional;
import java.util.PriorityQueue;

public class ScheduledJobPool {

    PriorityQueue<ScheduledJob> jobPriorityQueue;

    ScheduledJobPool() {
        this.jobPriorityQueue = new PriorityQueue<ScheduledJob>((a, b) -> Long.compare(a.startTime, b.startTime));
    }

    void addJob(ScheduledJob job) {
        jobPriorityQueue.add(job);
    }

    Optional<ScheduledJob> getNextScheduledJob(long currTime) {
        if (jobPriorityQueue.isEmpty() || jobPriorityQueue.peek().startTime > currTime)
            return null;
        return Optional.of(jobPriorityQueue.remove());
    }

}


