package SESSION02.BT3;

public class Main {
    public static void main(String[] args) {
        User user = new User("123456");
        System.out.println("Is authenticated: " + user.isAuthenticated());
        String encryptedPassword = Authenticatable.encrypt("123456");
        System.out.println("Encrypted password: " + encryptedPassword);
    }
}
