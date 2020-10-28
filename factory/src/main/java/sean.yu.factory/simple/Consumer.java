package sean.yu.factory.simple;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-21 10:43
 **/

public class Consumer {
    public static void main(String[] args) {
        //传统方法
        Car car1 = new Porsche();
        Car car2 = new Tesla();

        car1.name();
        car2.name();

        //简单/静态工厂
        Car car3 = CarFactory.getCar("porsche").get();
        Car car4 = CarFactory.getCar("tesla").get();
    }
}
