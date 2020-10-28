package sean.yu.factory.simple;

import java.util.Optional;

/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-21 10:31
 **/

//简单/静态工厂
public class CarFactory {
    public static Optional<Car> getCar(String brandName) {
        if("porsche".equals(brandName)) {
            return Optional.of(new Porsche());
        }else if("tesla".equals(brandName)) {
            return Optional.of(new Tesla());
        }
        return Optional.empty();
    }
}
