package v2;

/**
 * 第2个版本，将baby单独作为一个类，当有人调用wakeup时，baby开始哭
 * 而主程序任然是不断观察
 *
 * 所以本质上，v1,v2观察方式没有区别，只是v1是面向过程，v2是面向对象
 *
 *
 * @author: Sean Yu
 * @create: 2020-09-11 06:03
 **/
public class Main {
    public static void main(String[] args) {
        Baby baby = new Baby();
        while(!baby.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("observing...");
    }
}

class Baby{
    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("baby is crying");
        cry = true;
    }
}
