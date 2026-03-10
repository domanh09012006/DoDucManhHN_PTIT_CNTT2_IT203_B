package SESSION03;

import java.util.*;

record User4(String username, String email, String status) {}

public class BT4 {
    public static void main(String[] args) {

        List<User4> users = List.of(
                new User4("manh1", "manh1@gmail.com", "ok"),
                new User4("manh2", "manh2@yahoo.com", "ko"),
                new User4("manh3", "manh3@gmail.com", "ok"),
                new User4("manh2", "manh2@gmail.com", "ko")
        );

        Set<String> seen = new HashSet<>();

        users.stream()
                .filter(user -> seen.add(user.username()))
                .forEach(System.out::println);
    }
}
