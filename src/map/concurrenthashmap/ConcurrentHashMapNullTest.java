package map.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapNullTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentHashMapNullTest concurrentHashMapNullTest = new ConcurrentHashMapNullTest();
        try {
            concurrentHashMapNullTest.testPutWithNullKey(concurrentHashMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            concurrentHashMapNullTest.testPutWithNullValue(concurrentHashMap);
        }catch (Exception e){
            e.printStackTrace();;
        }
    }

    /**
     *
     * @param concurrentHashMap
     */
    public void testPutWithNullKey(ConcurrentHashMap concurrentHashMap) {
        concurrentHashMap.put(null, new String());
    }

    /**
     *
     * @param concurrentHashMap
     */
    public void testPutWithNullValue(ConcurrentHashMap concurrentHashMap) {
        concurrentHashMap.put("test key", null);
    }
}
