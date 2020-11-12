package v2.car;

/**
 * 用state模式来模拟车的状态
 * <p>
 * 假设能对车做4种动作： openDoor(), closeDoor(), run(), stop()
 * <p>
 * 对应有3种状态（不考虑开着门开车等不合理情况）: doorOpen && stop, doorClosed && running, doorClosed && stopped
 *
 * @author Sean Yu
 */
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("CAR-NO.1", new StateClosedAndStopped());
        System.out.println(car1);
        car1.closeDoor();
        car1.openDoor();
        car1.run();
        car1.stop();

        Car car2 = new Car("CAR-NO.2", new StateClosedAndRunning());
        System.out.println(car2);
        car2.closeDoor();
        car2.openDoor();
        car2.run();
        car2.stop();

        Car car3 = new Car("CAR-NO.3", new StateOpenAndStop());
        System.out.println(car3);
        car3.closeDoor();
        car3.openDoor();
        car3.run();
        car3.stop();
    }
}

class Car {
    private String name;
    private CarState state;

    public Car(String name, CarState state) {
        this.name = name;
        this.state = state;
    }

    public void openDoor() {
        state.openDoor();
    }

    public void closeDoor() {
        state.closeDoor();
    }

    public void run() {
        state.run();
    }

    public void stop() {
        state.stop();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}


abstract class CarState {
    abstract void openDoor();

    abstract void closeDoor();

    abstract void run();

    abstract void stop();
}

class StateOpenAndStop extends CarState {

    @Override
    void openDoor() {
        System.out.println("门已开，无需再开");
    }

    @Override
    void closeDoor() {
        System.out.println("门已关");
    }

    @Override
    void run() {
        System.out.println("门未关，不能开车");
    }

    @Override
    void stop() {
        System.out.println("已停止，无需再停");
    }

    @Override
    public String toString() {
        return "StateOpenAndStop{}";
    }
}

class StateClosedAndRunning extends CarState {

    @Override
    void openDoor() {
        System.out.println("正在行驶，无法开门，请先停车");
    }

    @Override
    void closeDoor() {
        System.out.println("门已关，无需再关");
    }

    @Override
    void run() {
        System.out.println("已在行驶，无需启动");
    }

    @Override
    void stop() {
        System.out.println("已停止");
    }

    @Override
    public String toString() {
        return "StateClosedAndRunning{}";
    }
}

class StateClosedAndStopped extends CarState {

    @Override
    void openDoor() {
        System.out.println("门已开");
    }

    @Override
    void closeDoor() {
        System.out.println("门已经关，无需再关");
    }

    @Override
    void run() {
        System.out.println("正在启动");
    }

    @Override
    void stop() {
        System.out.println("车已停止，无需再停");
    }

    @Override
    public String toString() {
        return "StateClosedAndStopped{}";
    }
}


