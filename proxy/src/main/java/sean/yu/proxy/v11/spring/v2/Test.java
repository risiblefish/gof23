package sean.yu.proxy.v11.spring.v2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sean.yu.proxy.Movable;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-16 08:00
 **/

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("v2.xml");
        Movable tank = (Movable) context.getBean("tank");
        tank.move();
    }
}
