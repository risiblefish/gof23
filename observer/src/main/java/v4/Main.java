package v4;

/**
 * 第4个版本，在v3的基础上，加入一个多个观察者，当baby哭的时候，触发各个观察者各自的方法
 *
 * 问题1：如此一来，当观察者数量多的时候，被观察对象与观察者的耦合度就会高
 *
 * 问题2：观察者的动作不一定耦合到某个具体的被观察者对象上，比如dog的bark动作，也许门外有人，dog想尿尿等情况也会触发
 *
 * @author: Sean Yu
 * @create: 2020-09-11 06:03
 **/
public class Main {
    public static void main(String[] args) {
        Baby baby = new Baby();
        baby.wakeUp();
    }
}

class Baby{
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mom mom = new Mom();
    private Dog dog = new Dog();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("baby is crying");
        cry = true;
        dad.feed();
        mom.hug();
        dog.bark();
    }
}

class Dad{
    public void feed(){
        System.out.println("now dad is feeding...");
    }
}

class Mom{
    public void hug(){
        System.out.println("now mom hugging baby...");
    }
}

class Dog{
    public void bark(){
        System.out.println("now dog barking...");
    }
}
