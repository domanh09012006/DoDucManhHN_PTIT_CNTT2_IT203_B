package SESSION03;

import java.util.List;
import java.util.Comparator;

record User5(String username, String email, String status) {}

public class BT5 {
    public static void main(String[] args) {

        List<User5> users = List.of(
                new User5("alexander", "a@gmail.com", "ACTIVE"),
                new User5("charlotte", "c@gmail.com", "ACTIVE"),
                new User5("Benjamin", "b@gmail.com", "ACTIVE"),
                new User5("tom", "t@gmail.com", "INACTIVE"),
                new User5("anna", "a@yahoo.com", "ACTIVE")
        );

        users.stream()
                .sorted(Comparator.comparingInt((User5 u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.username()));
    }
}