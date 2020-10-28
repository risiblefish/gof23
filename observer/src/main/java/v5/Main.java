package v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 第5个版本
 *
 * 1.定义一个wakeupobserver接口，里面有一个方法actionOnWakeUp()
 *
 * 2.将所有实现了接口的观察者放入集合，当baby哭的时候，触发集合中各个观察者各自的actionOnWakeUp（）方法
 *
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
    private boolean cry;
    private  List<WakeUpObserver> wakeUpObservers = new ArrayList<>();

    public Baby() {
        this.cry = false;
        wakeUpObservers.add(new Mom());
        wakeUpObservers.add(new Dad());
        wakeUpObservers.add(new Dog());
    }

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("baby is crying");
        cry = true;
        for (WakeUpObserver wakeUpObserver : wakeUpObservers) {
            wakeUpObserver.actionOnWakeUp();
        }
    }
}

interface WakeUpObserver{
    void actionOnWakeUp();
}

class Dad implements WakeUpObserver{
    public void feed(){
        System.out.println("now dad is feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mom implements WakeUpObserver{
    public void hug(){
        System.out.println("now mom hugging baby...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements WakeUpObserver{
    public void bark(){
        System.out.println("now dog barking...");
    }

    @Override
    public void actionOnWakeUp() {
        bark();
    }
}
