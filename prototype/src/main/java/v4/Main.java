package v4;

/**
 * v1 : 进过运行main可以发现，对于对象（非基础类型）的克隆，实际是引用拷贝，即p2的location与p1的location指向的是同一个对象
 * 所以它是浅拷贝。
 * <p>
 * v2 :
 * 让Person的属性Location实现cloneable接口，然后重写clone方法
 * 然后在Person的clone方法中，使用location.clone()来对loc进行赋值
 * <p>
 * 如此一来，就实现了深拷贝。
 * <p>
 * 问题， String引用需要深拷贝吗？
 * 答： 不需要，因为String存在常量池中，改变String的值，实际上是改变了它引用的对象。
 * 比如p1.street -> bj p2.street -> bj
 * 这里bj和sh都是常量池中的字符，所以p1.street和p2.street指向的同一个常量池中的引用
 * 然后将p2.street -> sh
 * 这并不会引起p1.street变成sh，上面的赋值操作，只会让p2.street指向sh这个常量
 * <p>
 * 问：如果street不是用双引号赋值法，而是用new String()/new StringBuilder()呢？
 * 答：new String()不会，而new StringBuilder()会。
 *
 * @author Sean Yu
 * @date 2020/11/3 12:28
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street.reverse();
        System.out.println("p1 : " + p1.loc);
        System.out.println("p2 : " + p2.loc);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuilder("bj"), 22);

    //只有实现了Cloneable接口，调用父类的clone才不会抛异常
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}

class Location implements Cloneable {
    StringBuilder street;
    int roomNo;

    public Location(StringBuilder street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
