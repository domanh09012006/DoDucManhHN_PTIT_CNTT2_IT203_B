package SESSION01;

import java.io.IOException;

public class BT4 {
    public static void saveToFile() throws IOException {
        System.out.println("Dang luu du lieu vao file...");
        throw new IOException("Loi khi ghi file");
    }
    public static void processUserData() throws IOException {
        System.out.println("Dang xu ly du lieu nguoi dung...");
        saveToFile();
    }
    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Da bat loi: " + e.getMessage());
        }
    }
}
