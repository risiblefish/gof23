package sean.yu.proxy.v11.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-16 07:53
 **/
@Aspect
public class TimeProxy {

    @Before("execution( void sean.yu.proxy.v11.spring.v2.Tank.move())")
    public void before() {
        System.out.println("start");
    }

    @After("execution( void sean.yu.proxy.v11.spring.v2.Tank.move())")
    public void after() {
        System.out.println("after");
    }
}
