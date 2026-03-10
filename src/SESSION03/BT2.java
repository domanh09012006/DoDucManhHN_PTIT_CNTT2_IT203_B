package SESSION03;

import java.util.List;

record User2(String username, String email, String status) {}

public class BT2 {
    public static void main(String[] args) {
        List<User2> users = List.of(
                new User2("alice", "alice@gmail.com", "ACTIVE"),
                new User2("bob", "bob@yahoo.com", "INACTIVE"),
                new User2("charlie", "charlie@gmail.com", "ACTIVE")
        );
        users.stream()
                .filter(user -> user.email().endsWith("gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}
