package SESSION03.BT3;

import java.util.List;
import java.util.Optional;


public class UserRepository {
    List<Main.User3> users = List.of(
            new Main.User3("alice", "alice@gmail.com", "ACTIVE"),
            new Main.User3("bob", "bob@yahoo.com", "INACTIVE"),
            new Main.User3("charlie", "charlie@gmail.com", "ACTIVE")
    );

    public Optional<Main.User3> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.username().equals(username))
                .findFirst();
    }
}
