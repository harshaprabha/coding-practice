package lld.rateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
    String name;
    long threshold;
    long duration;
    TimeUnit timeUnit;
    Map<String, Long[]> rateLimitingMap;
    int timeMultiplier;

    RateLimiter(String rule, long threshold, long duration, TimeUnit timeUnit) {
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
        else if (timeUnit == TimeUnit.MINUTES)
            timeMultiplier = (1000 * 60 * 60);
    }


    boolean checkIfRequestValid(String key) {
        System.out.println("Request Received from =" + Thread.currentThread().getName());
        synchronized (key.intern()) {
            // Add key if not present
            long currTimestamp = System.currentTimeMillis() / timeMultiplier;
            rateLimitingMap.putIfAbsent(key, new Long[]{currTimestamp, threshold});
            long lastTimestamp = rateLimitingMap.get(key)[0];

            // reset values if exceeded time duration
            if (currTimestamp - lastTimestamp >= duration)
                rateLimitingMap.put(key, new Long[]{currTimestamp, threshold});

            long allowedCalls = rateLimitingMap.get(key)[1];

            if (allowedCalls == 0)
                return false;

            rateLimitingMap.get(key)[1]--;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        RateLimiter rateLimiter = new RateLimiter("API", 3, 2, TimeUnit.SECONDS);

        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );

        Thread.sleep(5000);
        System.out.println("After break..");
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );
        System.out.println(rateLimiter.checkIfRequestValid("harsha") );


    }

}
