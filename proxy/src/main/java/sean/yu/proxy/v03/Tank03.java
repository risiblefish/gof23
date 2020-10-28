package sean.yu.proxy.v03;

import sean.yu.proxy.Movable;
import sean.yu.proxy.v01.Tank01;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:21
 **/

/**
 * 承接问题2：如果move()方法是别的包里的，不能修改，怎么办？
 * 答：可以通过继承，来重写move方法，添加额外的需求，比如这里的计时。
 *
 * 但是，但是，但是
 *
 * 在真正的日常工作中，继承一定要慎用，首先耦合度会增高，其次java单继承，如果再来需求，扩展能力会受阻，到时就只有再继承
 *
 * 那么 如何改进呢？
 */
public class Tank03 extends Tank01 {

    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(String.format("tank runs %s msec", (end - start)));
    }

    public static void main(String[] args) throws InterruptedException {
        new Tank03().move();
    }
}
