package SESSION13.BT5;

import java.sql.*;

public class ReceptionDAO {

    public void hienThiGiuongTrong() {
        String sql = "SELECT * FROM GiuongBenh WHERE trang_thai = 'Trong'";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--- DANH SACH GIUONG TRONG ---");
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.printf("Ma giuong: %d | Ten: %s\n", rs.getInt("ma_giuong"), rs.getString("ten_giuong"));
            }
            if (!hasData) System.out.println("Hien tai khong con giuong trong!");
        } catch (SQLException e) {
            System.out.println("Loi he thong: " + e.getMessage());
        }
    }

    public boolean tiepNhanBenhNhan(String ten, int tuoi, int maGiuong, double soTien) {
        Connection conn = null;
        try {
            conn = DatabaseHelper.getConnection();
            conn.setAutoCommit(false);

            String checkGiuong = "SELECT trang_thai FROM GiuongBenh WHERE ma_giuong = ?";
            try (PreparedStatement pstmtCheck = conn.prepareStatement(checkGiuong)) {
                pstmtCheck.setInt(1, maGiuong);
                ResultSet rs = pstmtCheck.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("Ma giuong khong ton tai!");
                }
                if (!rs.getString("trang_thai").equalsIgnoreCase("Trong")) {
                    throw new SQLException("Giuong nay da co nguoi nam!");
                }
            }

            int maBenhNhanMoi = 0;
            String insertBenhNhan = "INSERT INTO BenhNhan (ten_benh_nhan, tuoi, ma_giuong) VALUES (?, ?, ?)";
            try (PreparedStatement pstmtBN = conn.prepareStatement(insertBenhNhan, Statement.RETURN_GENERATED_KEYS)) {
                pstmtBN.setString(1, ten);
                pstmtBN.setInt(2, tuoi);
                pstmtBN.setInt(3, maGiuong);
                pstmtBN.executeUpdate();

                ResultSet generatedKeys = pstmtBN.getGeneratedKeys();
                if (generatedKeys.next()) {
                    maBenhNhanMoi = generatedKeys.getInt(1);
                }
            }

            String updateGiuong = "UPDATE GiuongBenh SET trang_thai = 'Da co nguoi' WHERE ma_giuong = ?";
            try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateGiuong)) {
                pstmtUpdate.setInt(1, maGiuong);
                pstmtUpdate.executeUpdate();
            }

            String insertPhieuThu = "INSERT INTO PhieuThu (ma_benh_nhan, so_tien, ngay_thu) VALUES (?, ?, NOW())";
            try (PreparedStatement pstmtThu = conn.prepareStatement(insertPhieuThu)) {
                pstmtThu.setInt(1, maBenhNhanMoi);
                pstmtThu.setDouble(2, soTien);
                pstmtThu.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Da hoan tac toan bo thao tac do co loi!");
                } catch (SQLException ex) {
                    System.out.println("Loi khi Rollback: " + ex.getMessage());
                }
            }
            System.out.println("Nguyen nhan loi: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
