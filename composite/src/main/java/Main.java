import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * 树状结构
 *
 * 这里的例子是有一个抽象类node，它有2种子节点，1种是分支节点（可以有子节点），1种是叶子节点（没有子节点）
 *
 *
 * @author: Sean Yu
 * @create: 2020-09-13 09:13
 **/
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        LeafNode c11 = new LeafNode("c11");
        LeafNode c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("session21");
        LeafNode c211 = new LeafNode("c211");
        LeafNode c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);

        chapter1.add(c11);
        chapter2.add(c12);

        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        printTree(root, 0);
    }

    /**
     * 打印以传入节点为根节点的子树
     * @param node
     * @param level 用来区分层级，层数越深，--越多
     */
    static void printTree(Node node, int level) {
        for (int i = 0; i < level - 1; i++) {
            System.out.print("--");
        }
        node.print();
        if (node instanceof BranchNode) {
            ((BranchNode) node).childList.forEach(child -> printTree(child, level + 1));
        }
    }
}

abstract class Node {
    public abstract void print();
}

class BranchNode extends Node {

    List<Node> childList;
    String content;

    public BranchNode(String content) {
        childList = new ArrayList<>();
        this.content = content;
    }

    public void add(Node node) {
        childList.add(node);
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}

class LeafNode extends Node {
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void print() {
        System.out.println(content);
    }
}

