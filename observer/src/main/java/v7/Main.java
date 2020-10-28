package v7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 第7个版本
 *
 * 很多时候，观察者不仅需要知道事件的细节，还需要知道事件的源对象，即产生事件的对象
 *
 * 比如，产生cry event的，可能是baby，也可以是puppy,而对于baby和puppy是有不同的动作来进行后续处理的
 *
 * 这时，可以把事件源对象作为event的一个属性source传递给观察者
 *
 * 因此，event里往往有一个方法叫getSource()
 *
 * 需要注意的是，事件源虽然可以传递给观察者，但是是通过事件传递过去的，而不是直接在观察者中把事件源定义成一个属性
 *
 * 即 事件源 - 事件（具有属性：事件源以及事件源的获取方法getSource()） - 观察者
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

class CryEvent{
    private LocalDateTime timeStamp;
    private int level;
    private Baby source;

    public CryEvent(LocalDateTime timeStamp, int level, Baby source) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.source = source;
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
