/**
 * @author: Sean Yu
 * @create: 2020-09-22 22:19
 **/
public class MyLinkedList implements Collection_{

    Node head;
    Node curr;
    int size = 0;

    public void add(int val){
        if(size == 0) {
            head = new Node(val);
            curr = head;
        }else {
            curr.next = new Node(val);
            curr = curr.next;
        }
        size++;
    }

    @Override
    public Iterator_ iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator_{
        Node p = head;

        @Override
        public Integer next() {
            p = p.next;
            return p == null ? null : p.val;
        }

        @Override
        public boolean hasNext() {
            return p.next != null;
        }
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator_ iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}


class Node{
    int val;
    Node next;


    public Node(int val) {
        this.val = val;
    }
}
