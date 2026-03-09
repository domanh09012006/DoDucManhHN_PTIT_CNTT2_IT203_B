package SESSION02.BT4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("manh1"));
        users.add(new User("manh2"));
        users.add(new User("manh3"));
        users.add(new User("manh4"));
        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        User newUser = new User();
        System.out.println(newUser.getUsername());
    }
}
