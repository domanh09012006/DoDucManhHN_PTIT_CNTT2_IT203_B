public List<BenhNhanDTO> getDashboardData() throws SQLException {
    Map<Integer, BenhNhanDTO> patientMap = new LinkedHashMap<>();
    String sql = "SELECT b.maBenhNhan, b.tenBenhNhan, " +
            "d.maDichVu, d.tenDichVu " +
            "FROM BenhNhan b " +
            "LEFT JOIN DichVuSuDung d ON b.maBenhNhan = d.maBenhNhan " +
            "ORDER BY b.maBenhNhan DESC";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            int maBN = rs.getInt("maBenhNhan");
            BenhNhanDTO patient = patientMap.get(maBN);
            if (patient == null) {
                patient = new BenhNhanDTO();
                patient.setMaBenhNhan(maBN);
                patient.setTenBenhNhan(rs.getString("tenBenhNhan"));

                // XỬ LÝ BẪY 2: Bắt buộc khởi tạo List rỗng để tránh văng lỗi NullPointerException khi Frontend nhận dữ liệu của bệnh nhân chưa có dịch vụ.
                patient.setDsDichVu(new ArrayList<>());
                patientMap.put(maBN, patient);
            }

            int maDV = rs.getInt("maDichVu");

            // XỬ LÝ BẪY 2: Dùng rs.wasNull() để check chính xác dòng dữ liệu trống sinh ra do LEFT JOIN. Nếu có dịch vụ thật mới add vào list, hệ thống không bỏ sót bệnh nhân và cũng không văng lỗi map dữ liệu rác.
            if (!rs.wasNull()) {
                DichVu dv = new DichVu();
                dv.setMaDichVu(maDV);
                dv.setTenDichVu(rs.getString("tenDichVu"));

                patient.getDsDichVu().add(dv);
            }
        }
    }
    return new ArrayList<>(patientMap.values());
}
/*
1. Input / Output:
- Input: Khong tham so.
- Output: List<BenhNhanDTO> (moi object chua thong tin va List<DichVu>).

2. So sanh & Lua chon giai phap:
- Giai phap 1 (Da chon): Dung 1 cau LEFT JOIN, group data bang LinkedHashMap tren Java
  + Uu diem: Chi 1 query (triet tieu lo N+1), DB chay cuc nhanh
  + Nhuoc diem: Data bi duplicate tren duong truyen.
- Giai phap 2: Dung 2 query (1 lay Benh Nhan, 1 lay Dich Vu bang IN clause)
  + Uu diem: Data sach, khong bi duplicate
  + Nhuoc diem: Ton 2 round-trips mạng, xu ly chuoi IN (?) dong rat cong kenh

3. Xu ly Bay nghiep vu:
- Bay 1 (Hieu nang): Da dung LEFT JOIN de gom ve 1 query duy nhat
- Bay 2 (Mat data & loi NPE):
  + Dung LEFT JOIN de giu lai nhung benh nhan chua duoc ke dich vu
  + Su dung "patient.setDsDichVu(new ArrayList<>())" de khoi tao mang rong tranh loi NPE
  + Dung "rs.wasNull()" de check chuan xac cot maDichVu la NULL roi moi add vao list
*/