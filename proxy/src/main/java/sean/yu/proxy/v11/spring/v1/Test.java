package sean.yu.proxy.v11.spring.v1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-16 08:00
 **/

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("v1.xml");
        Tank tank = (Tank) context.getBean("tank");
//        //如果aop代理不使用proxy target class，就要这么写：
//        Movable tank = (Movable) context.getBean("tank");
        tank.move();
    }
}
