package v2;

import com.sun.codemodel.internal.JStatement;

/**
 *
 * v1 : 如果用枚举表示state，当新增state的时候，
 * @author Sean Yu
 */
public class Main {
    public static void main(String[] args) {

    }
}

class MM {
    String name;
    MMState state;
    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }
}

abstract class MMState{
    abstract void smile();
    abstract void cry();
    abstract void say();
}

class MMHappyState extends MMState{

    @Override
    void smile() {

    }

    @Override
    void cry() {

    }

    @Override
    void say() {
        System.out.println("i'm happy");
    }
}

class MMSadState extends MMState{

    @Override
    void smile() {

    }

    @Override
    void cry() {

    }

    @Override
    void say() {
        System.out.println("i'm sad");
    }
}
