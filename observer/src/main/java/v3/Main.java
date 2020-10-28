package v3;

/**
 * 第3个版本，在v2的基础上，加入一个dad（观察者）作为baby的属性，当baby哭的时候，调用dad的feed()方法
 *
 * 即：将观察者作为属性放入目标对象中
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

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("baby is crying");
        cry = true;
        dad.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("now feeding...");
    }
}
