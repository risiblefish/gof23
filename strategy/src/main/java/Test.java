import java.util.ArrayList;
import java.util.Arrays;


/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-23 22:11
 **/

public class Test {
    public static void main(String[] args) {
        //按需求对cat排序
        Cat[] cats = new Cat[]
                {new Cat(1, 20), new Cat(2, 10)};
        Arrays.sort(cats, (c1, c2) -> c1.getHeight() - c2.getHeight());
        System.out.println(Arrays.toString(cats));
        Arrays.sort(cats, (c1, c2) -> c1.getWeight() - c2.getWeight());
        System.out.println(Arrays.toString(cats));
    }
}
