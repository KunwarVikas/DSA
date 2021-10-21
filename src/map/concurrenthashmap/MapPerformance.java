package map.concurrenthashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

public class MapPerformance {
    public static void main(String[] args) {
        MapPerformance mapPerformance = new MapPerformance();
        try {
            mapPerformance.testPerformance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testPerformance()throws Exception {
        Map<String, Object> hashtable = new Hashtable<String, Object>();
        Map<String, Object> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, Object>());
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();

        System.out.println("Time Elapsed for HashTable: "+ timeElapseForMapOperations(hashtable)+"ns");
        System.out.println("Time Elapsed for SynchronizedHashMap: "+ timeElapseForMapOperations(synchronizedHashMap)+"ns");
        System.out.println("Time Elapsed for ConcurrentHashMap: "+ timeElapseForMapOperations(concurrentHashMap)+"ns");

    }

    /**
     *
     * @param map
     * @return
     * @throws InterruptedException
     */
    private long timeElapseForMapOperations(Map<String, Object> map) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long startTime = System.nanoTime();
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 500000; j++) {
                    int value = ThreadLocalRandom
                            .current()
                            .nextInt(10000);
                    String key = String.valueOf(value);
                    map.put(key, value);
                    map.get(key);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        return (System.nanoTime() - startTime) / 500000;
    }
}
