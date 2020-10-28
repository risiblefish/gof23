package sean.yu.proxy.v11.spring.v1;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-16 07:53
 **/

public class TimeProxy {
    public void before(){
        System.out.println("start");
    }

    public void after(){
        System.out.println("after");
    }
}
