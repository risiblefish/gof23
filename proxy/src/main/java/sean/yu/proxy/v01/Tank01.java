package sean.yu.proxy.v01;

import sean.yu.proxy.Movable;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:17
 **/

/**
 * 一个实现了move方法的tank，它每次move都会随机消耗时间
 */
public class Tank01 implements Movable {
    public void move() throws InterruptedException {
        System.out.println("now tank running");
        Movable.delay();
    }
}

