package sean.yu.proxy.v02;

import sean.yu.proxy.Movable;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:21
 **/

/**
 * 问题：如果我们想记录每次tank move所花的时间，怎么破？
 * 答： 可以在move()的实现里，加入计时
 *
 * 问题2：如果move()方法是别的包里的，不能修改，怎么办？
 */
public class Tank02 implements Movable {

    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("now tank running");
        Movable.delay();
        long end = System.currentTimeMillis();
        System.out.println(String.format("tank runs %s msec", (end - start)));
    }

    public static void main(String[] args) throws InterruptedException {
        new Tank02().move();
    }
}
