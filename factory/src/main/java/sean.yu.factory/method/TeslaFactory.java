package sean.yu.factory.method;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-21 11:08
 **/

public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
