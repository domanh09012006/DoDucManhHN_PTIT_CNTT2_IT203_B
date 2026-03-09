package SESSION02.BT3;

@FunctionalInterface
interface Authenticatable {
    String getPassword();
    default boolean isAuthenticated() {
        String password = getPassword();
        if (password != null && password.isEmpty() == false) {
            return true;
        } else {
            return false;
        }
    }
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}


