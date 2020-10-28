package v8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 第8个版本
 *
 * 很多时候，事件也可以形成体系，比如cryEvent 抽象出一个父类 Event， 它具有抽象方法getSource
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
            wakeUpObserver.actionOnWakeUp(new CryEvent(LocalDateTime.now(),1,this));
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}

class CryEvent extends Event<Baby>{
    private LocalDateTime timeStamp;
    private int level;
    private Baby source;

    public CryEvent(LocalDateTime timeStamp, int level, Baby source) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.source = source;
    }

    @Override
    Baby getSource() {
        return source;
    }
}

interface WakeUpObserver{
    void actionOnWakeUp(CryEvent event);
}

class Dad implements WakeUpObserver {
    public void feed(CryEvent event){
        System.out.println("now dad is feeding...");
    }

    @Override
    public void actionOnWakeUp(CryEvent event) {
        feed(event);
    }
}

class Mom implements WakeUpObserver {
    public void hug(CryEvent event){
        System.out.println("now mom hugging baby...");
    }

    @Override
    public void actionOnWakeUp(CryEvent event) {
        hug(event);
    }
}

class Dog implements WakeUpObserver {
    public void bark(CryEvent event){
        System.out.println("now dog barking...");
    }

    @Override
    public void actionOnWakeUp(CryEvent event) {
        bark(event);
    }
}
