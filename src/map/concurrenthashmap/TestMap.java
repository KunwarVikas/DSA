package map.concurrenthashmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        ConcurrentModificationExceptionHashMap();
    }

    private static void ConcurrentModificationExceptionHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "TestValue1");
        hashMap.put(2, "TestValue2");
        hashMap.put(2, "TestValue3");
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            hashMap.put(4, "Test Modification");
            iterator.next();
        }
    }
}

//    private static void ConcurrentModificationExceptionSynchronizedHashMap() {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "Kunwar");
//        map.put(2, "Micheal");
//        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
//        Iterator<Map.Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            synchronizedMap.put(3, "Test Modification");
//            iterator.next();
//        }
//    }
//}
