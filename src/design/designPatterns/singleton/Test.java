package designPatterns.singleton;

import java.util.*;
import java.util.concurrent.*;

public class Test {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) {

        TreeMap<Integer,String> treeMap= new TreeMap<>();
        treeMap.put(1,"hello");
        treeMap.put(2,"prabha");

        while(!treeMap.isEmpty())
        {
            System.out.println(treeMap.pollFirstEntry());
        }
    }

    void method() throws ExecutionException, InterruptedException {
//
//        Map<String,TreeSet<String>> graph= new HashMap<>();
//        //graph.get("").
//        String s ="";
//            s.compareTo("2");
//        Character.isLetter('\s');
//        Random rand = new Random();
//        rand.nextInt(10);


       // Integer.compare(x,y)


//        //Map<String,List<String>> map= new HashMap<>();
//        //map.put("",map.get("").add("aa"));
//        Deque<Future<List<String>>> dq = new LinkedBlockingDeque<>();
//        Set<String> visited= new HashSet<>();
//        map.putIfAbsent("",new ArrayList<>());

        //CompletableFuture.supplyAsync(()-> )

//        Callable<List<String>> callable = new Callable<List<String>>() {
//            @Override
//            public List<String> call() throws Exception {
//                return null;
//            }
//        };
//
//        Future<List<String>> f = executorService.submit(callable);

    }


}

