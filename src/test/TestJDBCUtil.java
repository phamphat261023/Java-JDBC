package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main (String[] args) {
//		try {
//			// Tạo kết nối
//			Connection connection = JDBCUtil.getConnection();
//			
//			// Tạo đối tượng statement
//			Statement st = connection.createStatement();
//			
//			// Thực thi câu lệnh sql
//			String sql = "INSERT INTO KhoHang(Mahang, Tenhang, Soluong)"
//						+ "VALUES (111,\"Oto\" , 2)";
//			int check = st.executeUpdate(sql);
//			
//			// Xử lý kết quả
//			System.out.println("So dong thay doi: " + check);
//			if(check > 0) {
//				System.out.println("Them du lieu thanh cong!!");
//			}
//			else {
//				System.out.println("Them du lieu that bai!!");
//			}
//			
//			// Ngắt kết nối
//			JDBCUtil.closeConnection(connection);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
