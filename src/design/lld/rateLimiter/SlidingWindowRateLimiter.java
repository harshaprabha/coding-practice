package lld.rateLimiter;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SlidingWindowRateLimiter {

    String name;
    long threshold;
    long duration;
    TimeUnit timeUnit;
    Map<String, Deque<Long>> rateLimitingMap;
    int timeMultiplier;

    SlidingWindowRateLimiter(String rule, long threshold, long duration, TimeUnit timeUnit) {
        this.name = rule;
        this.threshold = threshold;
        this.rateLimitingMap = new HashMap<>();
        this.duration = duration;
        this.timeUnit = timeUnit;
        this.timeMultiplier = 1;
        initializeTimeMultiplier(timeUnit);
    }

    void initializeTimeMultiplier(TimeUnit timeUnit) {
        if (timeUnit == TimeUnit.SECONDS)
            timeMultiplier = 1000;
        else if (timeUnit == TimeUnit.MINUTES)
            timeMultiplier = (1000 * 60);
    }

    boolean checkIfRequestValid(String key) {
        System.out.println("Request Received time =" + System.currentTimeMillis());

        long currTimestamp = System.currentTimeMillis() / timeMultiplier;

        rateLimitingMap.putIfAbsent(key, new LinkedList<>());
        Deque<Long> keyQueue = rateLimitingMap.get(key);

        while (!keyQueue.isEmpty() && currTimestamp - keyQueue.peekFirst() >= duration)
            keyQueue.pollFirst();

        if (keyQueue.size() == threshold)
            return false;

        rateLimitingMap.get(key).addLast(currTimestamp);
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter("API", 3, 2, TimeUnit.SECONDS);
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));

        Thread.sleep(2000);
        System.out.println("After break...");
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));
        System.out.println(rateLimiter.checkIfRequestValid("harsha"));


    }


}
