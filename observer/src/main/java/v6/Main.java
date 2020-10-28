package v6;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 第6个版本
 *
 * 在真实的环境中，观察者接受到的事件往往不是简单的cry
 * 比如对于婴儿哭闹的时间不同，哭闹的程度不同，观察者要有不同的处理方式
 *
 * 从代码的角度来说，为了描述cry的细节，需要加上一些参数，对此，可以把cry抽象成CryEvent，然后把event传给各个观察者
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
            wakeUpObserver.actionOnWakeUp(new CryEvent(LocalDateTime.now(),1));
        }
    }
}

class CryEvent{
    private LocalDateTime timeStamp;
    private int level;

    public CryEvent(LocalDateTime timeStamp, int level) {
        this.timeStamp = timeStamp;
        this.level = level;
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
