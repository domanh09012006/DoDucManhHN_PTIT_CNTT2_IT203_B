package SESSION03.BT3;

public class Main {
    public record User3(String username, String email, String status) {

    }
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        User3 user = repo.findUserByUsername("alice")
                .orElse(new User3("guest", "", ""));
        if (user.username().equals("guest")) {
            System.out.println("Guest login");
        } else {
            System.out.println("Welcome " + user.username());
        }
    }
}
