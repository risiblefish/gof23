/**
 * visitor 模式
 *
 * 案例模拟：
 * 假设需要做一个电脑装机业务，其中电脑包含主板，内存，cpu。
 * 假如来装机的顾客是学生，那么就享受学生折扣，如果顾客是企业人员，就享受企业折扣
 * @author: Sean Yu
 * @create: 2020-09-24 22:39
 **/
public class Computer {
    ComputerPart cpu = new Cpu();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v){
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        Computer computerToSale = new Computer();
        StudentVisitor studentVisitor = new StudentVisitor();
        computerToSale.accept(studentVisitor);
        System.out.println("学生购买本电脑需要花费"+studentVisitor.totalPrice);
    }
}

abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract double getPrice();
}

class Cpu extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 700;
    }
}

abstract class Visitor{
    abstract void visitCpu(Cpu cpu);
    abstract void visitMemory(Memory memory);
    abstract void visitBoard(Board board);
}

class StudentVisitor extends Visitor{
    int totalPrice = 0;
    double studentDisCount = 0.8;

    @Override
    void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice() * studentDisCount;
    }

    @Override
    void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * studentDisCount;
    }

    @Override
    void visitBoard(Board board) {
        totalPrice += board.getPrice() * studentDisCount;
    }
}
