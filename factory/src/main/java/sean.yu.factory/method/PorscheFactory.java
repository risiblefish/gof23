package sean.yu.factory.method;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-21 11:08
 **/

public class PorscheFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Porsche();
    }
}
