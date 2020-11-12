/**
 * 模板方法举例
 * <p>
 * 通过父类创建框架，调用统一的模板方法，然后将部分实现延迟到子类去实现
 *
 * @author Sean Yu
 */
public class Main {
    public static void main(String[] args) {
        Cook chinese = new ChineseCook();
        chinese.provideDish();

        Cook french = new FrenchCook();
        french.provideDish();
    }
}

/**
 * 定义父类 厨子：
 *
 * 其中包含模板方法上菜（provideDish）， 模板方法包括3个子环节（食物，饮品，小吃）
 * 这3个子环节被定义为抽象方法，由子类来负责实现
 */
abstract class Cook {
    public void provideDish() {
        provideFood();
        provideDrink();
        provideSnack();
    }

    abstract void provideFood();

    abstract void provideDrink();

    abstract void provideSnack();
}

class ChineseCook extends Cook {

    @Override
    void provideFood() {
        System.out.println("上菜环节：北京烤鸭");
    }

    @Override
    void provideDrink() {
        System.out.println("饮品环节：飞天茅台");
    }

    @Override
    void provideSnack() {
        System.out.println("小吃环节 ：冰糖葫芦 ");
    }
}

class FrenchCook extends Cook {

    @Override
    void provideFood() {
        System.out.println("上菜环节：鹅肝");
    }

    @Override
    void provideDrink() {
        System.out.println("饮品环节：拉菲");
    }

    @Override
    void provideSnack() {
        System.out.println("小吃环节 ：布丁");
    }
}


