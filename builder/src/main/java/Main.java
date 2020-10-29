/**
 * @author: Sean Yu
 * @create: 2020-10-29 22:13
 **/
public class Main {
    public static void main(String[] args) {
        User me = new User
                .UserBuilder("Sean","Yu")
                .age(99)
                .phone(123)
                .email("aa").build();

        System.out.println(me.toString());
    }
}
