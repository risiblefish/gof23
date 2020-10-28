package sean.yu.proxy.v08;

import sean.yu.proxy.Movable;
import sean.yu.proxy.v01.Tank01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-08 22:21
 **/

/**
 * v01： 有个tank类实现了Movable接口的move()方法
 * 问1： 如果想记录move()时间怎么办？
 * <p>
 * v02： 在move方法里记录起止时间
 * 问2：如果move()方法是别的包里的，不能修改，想记录时间，怎么办？
 * <p>
 * v03：通过继承tank，重写move()，在重写方法中记录时间，调用super.move()
 * <p>
 * 问3：真正的日常工作中，继承一定要慎用，首先耦合度会增高，其次java单继承
 * 如果再来需求，比如要求记录一下日志等， 扩展能力会受阻，到时就只有再继承或者修改重写的方法。
 * <p>
 * 个人理解：对于继承，个人觉得，主要是单继承影响扩展，
 * 至于对父类的方法新增操作，只需要在子类的重写方法里不断加代码即可，但这样会违反单一职责，
 * 这样一来，重写的move方法，既要计时，又要记日志，它的功能范畴早已超出了move()方法本身
 * <p>
 * v04: 通过代理，即用代理类实现与被代理对象所实现的相同接口，然后在代理类中，调用被代理对象的方法。
 * 比如下面的TankTimeProxy,也去实现Movable接口，然后为代理类设置一个属性，这个属性就是被代理对象tank，
 * 然后在代理类的move中调用tank.move，同时还可以实现计时
 * <p>
 * 问4：如果这时来了个需求，让你增加一个日志，记录一下执行了move（）这个行为，怎么破？
 * <p>
 * v05: 增加一个代理类，同样实现Movable接口
 * 问5：如此一来，时间代理和日志代理都会调用tank.move()，但这是2个move，有没有办法对同1个move进行计时和记日志的操作？
 * <p>
 * v06: 使用静态代理，将Tank抽象化为Movable，实现"嵌套"
 * 问6： 如果想让代理类 不止代理Movable, 而是可以代理任何接口，比如计算时间，记录日志等行为，具有普遍性，该怎么做？
 * <p>
 * v07: 本质上讲，这种是分离代理行为和被代理对象。可以用jdk的动态代理来实现。
 * <p>
 * 对比一下静态代理，因为知道被代理对象实现了哪个接口，（即知道了这个接口里有哪些方法），所以静态代理可以代理到具体的方法上去。
 * <p>
 * 问7：如果被代理对象实现的接口不止1个方法，我们只想增强某1个方法，使用动态代理如何实现?
 * <p>
 * <p>
 * <p>
 * 试想，万一被代理的类没有实现接口，这种情况不能使用静态代理，该如何解决呢（动态代理也无法实现，需要使用cglib等工具）
 */
public class Tank08 {
    public static void main(String[] args) {
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");//jdk12
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");//jdk8
        TwoMethodObj to = new TwoMethodObj();
        TwoMethod proxyInstance = (TwoMethod) Proxy.newProxyInstance(
                TwoMethodObj.class.getClassLoader(),
                TwoMethodObj.class.getInterfaces(),
                new TwoMethodProxy(to));
        proxyInstance.f1();
        proxyInstance.f2();
    }
}

class TwoMethodProxy implements InvocationHandler {

    TwoMethod t;

    TwoMethodProxy(TwoMethod t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        if ("f1".equals(method.getName())) {
            System.out.println("start f1()");
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis();
            o = method.invoke(t, args);
            System.out.println(String.format("tank runs %s msec", (end - start)));
        }
        return o;
    }
}


class TwoMethodObj implements TwoMethod {

    @Override
    public void f1() {
        System.out.println("f1");
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }
}

interface TwoMethod {
    void f1();

    void f2();
}

