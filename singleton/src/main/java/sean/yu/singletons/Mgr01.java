package sean.yu.singletons;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用
 * 唯一缺点： 不管使用与否，类装载时就完成实例化
 **/
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    //注意到，此处将构造器私有化，防止被new
    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    //随便写的一个业务方法
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
