/**
 * @author: Sean Yu
 * @create: 2020-11-01 13:05
 **/
public class Main {
    public static void main(String[] args) {
        new GG().chase(new MM("momo"));
    }
}

class GG {
    public void chase(MM mm) {
        Gift gift1 = new WarmGift(new Flower());
        Gift gift2 = new WildGift(new Book());
        give(mm, gift1);
        give(mm, gift2);
    }

    public void give(MM mm, Gift gift) {
        System.out.println(String.format("Gift[%s] gave to MM[%s]", gift.impl.getName(), mm.name));
    }
}


class MM {
    String name;

    public MM(String name) {
        this.name = name;
    }
}

abstract class Gift {
    GiftImpl impl;
}

abstract class GiftImpl {
    abstract String getName();
}

class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }
}

class WildGift extends Gift {
    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}

class Book extends GiftImpl {

    @Override
    String getName() {
        return "book";
    }
}

class Flower extends GiftImpl {

    @Override
    String getName() {
        return "flower";
    }
}