/**
 * @program: gof23
 * @description:
 * @author: Unuts
 * @create: 2020-06-23 22:41
 **/
public class ComparableDog implements Comparable{
    private int weight;
    private int height;

    public ComparableDog(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        Dog obj = (Dog)o;
        return this.weight -  obj.getWeight();
    }
}
