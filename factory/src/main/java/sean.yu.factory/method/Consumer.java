package sean.yu.factory.method;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-21 10:43
 **/

//工厂方法模式
public class Consumer {
    public static void main(String[] args) {
        Car car1 = new PorscheFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
    }
}
