import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Sean Yu
 * @create: 2020-09-13 22:11
 **/
public class Main {
}

class Bullet{
    private UUID id = UUID.randomUUID();
    private boolean living = true;

    public boolean isLiving() {
        return living;
    }

    public UUID getId() {
        return id;
    }
}

class BulletPool{
    List<Bullet> bulletList = new ArrayList<>();
    {
        System.out.println("now init bullet pool");
        for (int i = 0; i < 5; i++) {
            bulletList.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = bulletList.get(i);
            if(b.isLiving()) {
                return b;
            }
        }
        return new Bullet();
    }
}
