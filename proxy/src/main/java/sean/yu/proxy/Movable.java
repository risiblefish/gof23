package sean.yu.proxy;

import java.util.Random;

public interface Movable {
    void move() throws InterruptedException;

    //模拟延时
    static void delay() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10000));
    }
}
