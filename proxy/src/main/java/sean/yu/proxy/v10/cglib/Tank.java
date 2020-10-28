package sean.yu.proxy.v10.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-07-15 08:04
 **/

public class Tank {
    public void move(){
        System.out.println("now tank running");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank)enhancer.create();
        tank.move();
    }
}


class TimeMethodInterceptor implements MethodInterceptor{

    long start;
    long end;

    public void before(){
        start = System.currentTimeMillis();
        System.out.println("start...");
    }

    public void after(){
        end = System.currentTimeMillis();
        System.out.println("end, spend " + (end - start) + "msc");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //思考，o是什么？ 和jdk动态代理一样，这里的o也是动态生成的代理类的对象。
        System.out.println(o.getClass().getSuperclass().getName());
        before();
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }
}
