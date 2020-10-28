package sean.yu.singletons;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * 懒汉式 lazy loading
 * 当使用的时候才进行加载，但会导致线程不安全问题
 **/
public class Mgr05 {

    //此处不再有final
    private static volatile Mgr05 INSTANCE;

    //注意到，此处将构造器私有化，防止被new
    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //试图缩小同步代码块来提高性能
            synchronized (Mgr05.class) {
                //双重检查，一旦发现INSTANCE有引用，便跳过new，线程安全
                if(INSTANCE == null) {
                    //这段try catch主要是为了模拟一些延时，让线程不安全的问题体现得更明显
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        System.out.println("throw exception");
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
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
            Integer currMgrHashCode = Mgr05.getInstance().hashCode();
            System.out.println(currMgrHashCode);
            map.put(currMgrHashCode, map.getOrDefault(currMgrHashCode, 0) + 1);
        }).start());
        System.out.println(map);
    }
}
