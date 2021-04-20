package lld.rateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TokenBucket {

    String name;
    long duration;
    long maxLimit;
    TimeUnit timeunit;
    int capacity;
    Map<String, Long[]> requestsMap;

    TokenBucket(String n, long duration, long maxLimit, TimeUnit timeUnit, int capacity) {
        this.name = n;
        this.duration = duration;
        this.maxLimit = maxLimit;
        this.timeunit = timeUnit;
        requestsMap = new HashMap<>();
        this.capacity = capacity;
    }


    boolean isRequestAllowed(String key) {

        long currTimestamp = System.currentTimeMillis();
        requestsMap.putIfAbsent(key, new Long[]{currTimestamp, maxLimit});

        long prevTimestamp = requestsMap.get(key)[0];
        long limit = requestsMap.get(key)[1];

        if (currTimestamp - prevTimestamp >= duration) {
            long currLimit = Math.min(limit + maxLimit, capacity);
            requestsMap.get(key)[0] = currTimestamp;
            requestsMap.get(key)[1] = currLimit;
        }

        if (requestsMap.get(key)[1] == 0)
            return false;

        requestsMap.get(key)[1]--;
        return true;

    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket rateLimiter = new TokenBucket("UserAccess", 1, 3, TimeUnit.SECONDS, 10);
        if (rateLimiter.isRequestAllowed("test"))
            System.out.println("Allowed");
        else
            System.out.println("Not Allowed");

        Thread.sleep(2000);
        for (int calls = 0; calls < 7; calls++) {
            if (rateLimiter.isRequestAllowed("test"))
                System.out.println("Allowed");
            else
                System.out.println("Not Allowed");
        }


    }
}
