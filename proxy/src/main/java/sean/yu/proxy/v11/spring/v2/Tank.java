package sean.yu.proxy.v11.spring.v2;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:17
 **/
import sean.yu.proxy.Movable;

/**
 * 一个实现了move方法的tank，它每次move都会随机消耗时间
 */
public class Tank implements Movable {
    @Override
    public void move(){
        System.out.println("now tank running");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

