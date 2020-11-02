package v2;

import java.util.ArrayList;
import java.util.List;

/**
 * v1 问题： 如何实现一连串的undo？
 *
 * v2 : 使用cor
 *
 * 下面的实现是一次性做完所有do和undo， 】
 * 如果要更灵活， 可以将所有command放到一个链表里，
 * 每次执行新的command，实际的操作是（先将command加到链表里，再执行command的doit）
 * 每次执行undo,实际操作是（从链表中取出最后一个command，执行该command的undo），然后将这个command移出链表
 *
 * @author Sean Yu
 * @date 2020/11/2 11:38
 */
public class Main {
    public static void main(String[] args) {
        Content c = new Content();
        Chain chain = new Chain().add(new InsertCommand(c)).add(new CopyCommand(c)).add(new DeleteCommand(c));
        chain.doit(chain);
        chain.undo(chain);
    }
}

abstract class Command {
    Content c;

    public abstract void doit(Chain chain);

    public abstract void undo(Chain chain);
}

class Content {
    String msg = "hello from sean";
}

class InsertCommand extends Command {
    String strToInsert = "InsertStr";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit(Chain chain) {
        c.msg = c.msg + strToInsert;
        System.out.println(c.msg);
        chain.doit(chain);
    }

    @Override
    public void undo(Chain chain) {
        c.msg = c.msg.substring(0, c.msg.length() - strToInsert.length());
        System.out.println(c.msg);
        chain.undo(chain);
    }
}

class DeleteCommand extends Command {
    String deleted;
    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit(Chain chain) {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
        System.out.println(c.msg);
        chain.doit(chain);
    }

    @Override
    public void undo(Chain chain) {
        c.msg = deleted + c.msg;
        System.out.println(c.msg);
        chain.undo(chain);
    }
}

class CopyCommand extends Command {

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit(Chain chain) {
        c.msg = c.msg + c.msg;
        System.out.println(c.msg);
        chain.doit(chain);
    }

    @Override
    public void undo(Chain chain) {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
        System.out.println(c.msg);
        chain.undo(chain);
    }
}

class Chain {
    List<Command> commands = new ArrayList<>();

    int index = 0;

    public Chain add(Command c) {
        commands.add(c);
        return this;
    }

    public void doit(Chain chain) {
        if (index == commands.size()) {
            return;
        }
        commands.get(index++).doit(chain);
    }

    public void undo(Chain chain) {
        if (index == 0) {
            return;
        }
        commands.get(--index).undo(chain);
    }
}