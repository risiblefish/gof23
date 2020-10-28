package sean.yu.singletons;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 *  枚举单例，不仅可以解决线程同步导致的性能问题，还能防止反序列化
 */
public enum Mgr07 {
    INSTANCE;

    //业务方法
    public void m(){
        System.out.println("m");
    }
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        IntStream.rangeClosed(0, 99).parallel().forEach(i -> new Thread(() -> {
            Integer currMgrHashCode = Mgr07.INSTANCE.hashCode();
            map.put(currMgrHashCode, map.getOrDefault(currMgrHashCode, 0) + 1);
        }).start());
        System.out.println(map);
    }
}
