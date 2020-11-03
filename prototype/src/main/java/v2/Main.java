package v2;

/**
 * v1 : 进过运行main可以发现，对于对象（非基础类型）的克隆，实际是引用拷贝，即p2的location与p1的location指向的是同一个对象
 * 所以它是浅拷贝。
 *
 * v2 :
 * 让Person的属性Location实现cloneable接口，然后重写clone方法
 * 然后在Person的clone方法中，使用location.clone()来对loc进行赋值
 *
 * 如此一来，就实现了深拷贝。
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
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);

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
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
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
