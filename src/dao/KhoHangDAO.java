package dao;

import java.util.ArrayList;
import model.KhoHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class KhoHangDAO implements DAOInterface<KhoHang> {
	
	public static KhoHangDAO getInstance () {
		return new KhoHangDAO();
	}

	@Override
	public int insert(KhoHang t) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			//Tạo kết nối
			Connection c = JDBCUtil.getConnection();
			//Thực thi câu lệnh
			String sql = "INSERT INTO KhoHang(Mahang, Tenhang, Soluong)"
						+ "VALUES(?, ?, ?)";
			//Tạo preparedStatement
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, t.getMaHang());
			pst.setString(2, t.getTenHang());
			pst.setInt(3, t.getSl());
			
			result = pst.executeUpdate();
			//Xử lý kết quả
			System.out.println("Bạn đã thực thi lệnh: " + sql);
			System.out.println("Có "+result+" thay đổi trong csdl ");
			//Ngát kết nối
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(KhoHang t) {
		// TODO Auto-generated method stub
		int updateResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String updateSql = "UPDATE KhoHang "+
					 " SET " +
					 " Tenhang=?"+
					 ", Soluong=?"+
					 " WHERE Mahang=?";
			PreparedStatement pst = c.prepareStatement(updateSql);
			pst.setString(1, t.getTenHang());
			pst.setInt(2, t.getSl());
			pst.setInt(3, t.getMaHang());
			
			updateResult = pst.executeUpdate();
			System.out.println("Ban da thuc thi cau lenh: " + updateSql);
			System.out.println("Co "+updateResult+" duoc cap nhap trong csdl ");
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateResult;
	}

	@Override
	public int delete(KhoHang t) {
		// TODO Auto-generated method stub
		int deleteResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String deleteSql = "DELETE FROM KhoHang WHERE Mahang = ?";
			PreparedStatement pst = c.prepareStatement(deleteSql);
			pst.setInt(1, t.getMaHang());
			
			deleteResult = pst.executeUpdate();
			System.out.println("Ban da thuc thi cau lenh: " + deleteSql);
			System.out.println("Co "+deleteResult+" duoc xoa trong csdl ");
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<KhoHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<KhoHang> listKH = new ArrayList<KhoHang>();
		try {
			Connection c = JDBCUtil.getConnection();
			String selectSql = "SELECT * FROM KhoHang";
			PreparedStatement pst = c.prepareStatement(selectSql);
			System.out.println(selectSql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int Mahang = rs.getInt("Mahang");
				String Tenhang = rs.getString("Tenhang");
				int Soluong = rs.getInt("Soluong");
				
				KhoHang khohang = new KhoHang(Mahang, Tenhang, Soluong);
				listKH.add(khohang);
			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listKH;
	}

	@Override
	public KhoHang selectById(KhoHang t) {
		// TODO Auto-generated method stub
		KhoHang result = null;
		try {
			Connection c = JDBCUtil.getConnection();
			String selectById = "SELECT * FROM KhoHang WHERE Mahang = ?";
			PreparedStatement pst = c.prepareStatement(selectById);
			pst.setInt(1,  t.getMaHang());
			
			System.out.println(selectById);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int Mahang = rs.getInt("Mahang");
				String Tenhang = rs.getString("Tenhang");
				int Soluong = rs.getInt("Soluong");
				
				result = new KhoHang(Mahang, Tenhang, Soluong);
			}
			JDBCUtil.closeConnection(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<KhoHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<KhoHang> listKH = new ArrayList<KhoHang>();
		try {
			Connection c = JDBCUtil.getConnection();
			String selectCondition = "SELECT * FROM KhoHang WHERE "+condition;
			PreparedStatement pst = c.prepareStatement(selectCondition);
			System.out.println(selectCondition);
			ResultSet rs = pst.executeQuery(selectCondition);
			
			while(rs.next()) {
				int Mahang = rs.getInt("Mahang");
				String Tenhang = rs.getString("Tenhang");
				int Soluong = rs.getInt("Soluong");
				KhoHang khohang = new KhoHang(Mahang, Tenhang, Soluong);
				listKH.add(khohang);
			}
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listKH;
	}

}
