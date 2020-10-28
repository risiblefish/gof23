package sean.yu.singletons;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，从而实现懒加载
 **/
public class Mgr06 {

    //注意到，此处将构造器私有化，防止被new
    private Mgr06() {
    }

    //静态内部类
    private static class Mgr06Holder{
        private final static Mgr06 INSTANCE = new Mgr06();
    }

    public static Mgr06 getInstance() {
        return Mgr06Holder.INSTANCE;
    }

    //随便写的一个业务方法
    public void m() {
        System.out.println("m");
    }

    /**
     * 测试方法，使用一个线程安全的map，起100个线程，分别进行getInstance操作，然后将该次获取到的实例的hashcode存入map进行计数
     *
     * @param args
     */
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        IntStream.rangeClosed(0, 99).parallel().forEach(i -> new Thread(() -> {
            Integer currMgrHashCode = Mgr06.getInstance().hashCode();
            map.put(currMgrHashCode, map.getOrDefault(currMgrHashCode, 0) + 1);
        }).start());
        System.out.println(map);
    }
}
