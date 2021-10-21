package map.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapStreamExample {
    public static void main(final String[] args) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            concurrentHashMap.put(i, i);
        }
        concurrentHashMap.forEach((num1,num2) -> {
            if (num2 % 2 == 0) {
                System.out.println("Given " + num2 +" is an even number");
            }
        });
    }
}
