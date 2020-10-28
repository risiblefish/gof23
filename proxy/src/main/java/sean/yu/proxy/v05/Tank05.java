package sean.yu.proxy.v05;

import sean.yu.proxy.Movable;
import sean.yu.proxy.v01.Tank01;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:21
 **/

/**
 * v01： 有个tank类实现了Movable接口的move()方法
 * 问1： 如果想记录move()时间怎么办？
 *
 * v02： 在move方法里记录起止时间
 * 问2：如果move()方法是别的包里的，不能修改，想记录时间，怎么办？
 *
 * v03：通过继承tank，重写move()，在重写方法中记录时间，调用super.move()
 *
 * 问3：真正的日常工作中，继承一定要慎用，首先耦合度会增高，其次java单继承
 * 如果再来需求，比如要求记录一下日志等， 扩展能力会受阻，到时就只有再继承或者修改重写的方法。
 *
 * 个人理解：对于继承，个人觉得，主要是单继承影响扩展，
 * 至于对父类的方法新增操作，只需要在子类的重写方法里不断加代码即可，但这样会违反单一职责，
 * 这样一来，重写的move方法，既要计时，又要记日志，它的功能范畴早已超出了move()方法本身
 *
 * v04: 通过代理，即用代理类实现与被代理对象所实现的相同接口，然后在代理类中，调用被代理对象的方法。
 * 比如下面的TankTimeProxy,也去实现Movable接口，然后为代理类设置一个属性，这个属性就是被代理对象tank，
 * 然后在代理类的move中调用tank.move，同时还可以实现计时
 *
 * 问4：如果这时来了个需求，让你增加一个日志，记录一下执行了move（）这个行为，怎么破？
 *
 * v05: 增加一个代理类，同样实现Movable接口
 * 问5：如此一来，时间代理和日志代理都会调用tank.move()，但这是2个move，有没有办法对同1个move进行计时和记日志的操作？
 *
 * v06: 使用静态代理，将Tank抽象化为Movable，实现"嵌套"
 *
 */
public class Tank05  {
    public static void main(String[] args) throws InterruptedException {
        Tank01 tank01 = new Tank01();
    }
}

class TankTimeProxy implements Movable{
    private Tank01 tank01;

    public TankTimeProxy(Tank01 tank01) {
        this.tank01 = tank01;
    }
    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        tank01.move();
        long end = System.currentTimeMillis();
        System.out.println(String.format("tank runs %s msec", (end - start)));
    }
}

class TankLogProxy implements Movable{
    private Tank01 tank01;

    public TankLogProxy(Tank01 tank01) {
        this.tank01 = tank01;
    }

    @Override
    public void move() throws InterruptedException {
        System.out.println("now recording log");
        tank01.move();
    }
}
