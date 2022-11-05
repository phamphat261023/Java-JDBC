package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietDatHang;

public class ChiTietDHDAO implements DAOInterface<ChiTietDatHang> {
	
	public static ChiTietDHDAO getInstance () {
		return new ChiTietDHDAO();
	}

	@Override
	public int insert(ChiTietDatHang t) {
		// TODO Auto-generated method stub
		int insertResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String insertSql = "INSERT INTO ChiTietDatHang (Mahang, Giaban, Soluongmua) "
							+ "VALUES ('"+t.getMaHang()+"', '"+t.getGiaBan()+"', '"+t.getSlMua()+"')";
			System.out.println(insertSql);
			insertResult = st.executeUpdate(insertSql);
			System.out.println("Da co "+insertResult+" duoc them vao database ");
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return insertResult;
	}

	@Override
	public int update(ChiTietDatHang t) {
		// TODO Auto-generated method stub
		int updateResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String updateSql = "UPDATE ChiTietDatHang "+
					 " SET " +
					 " Giaban='"+ t.getGiaBan()+"'"+
					 ", Soluongmua="+ t.getSlMua()+
					 " WHERE Mahang='"+t.getMaHang()+"\'";
			updateResult = st.executeUpdate(updateSql);
			System.out.println(updateSql);
			System.out.println("Co '"+updateResult+"' dong duoc cap nhat trong databse ");
			JDBCUtil.closeConnection(c);						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateResult;
	}

	@Override
	public int delete(ChiTietDatHang t) {
		// TODO Auto-generated method stub
		int deleteResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String deleteSql = "DELETE FROM ChiTietDatHang WHERE Mahang = '"+t.getMaHang()+"' ";
			deleteResult = st.executeUpdate(deleteSql);
			System.out.println(deleteSql);
			System.out.println("Co "+deleteResult+" duoc xoa trong database ");
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deleteResult;
	}

	@Override
	public ArrayList<ChiTietDatHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<ChiTietDatHang> listDH = new ArrayList<ChiTietDatHang>();
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String selectSql = "SELECT * FROM ChiTietDatHang";
			System.out.println(selectSql);
			ResultSet rs = st.executeQuery(selectSql);
			
			while(rs.next()){
				int Mahang = rs.getInt("Mahang");
				int Giaban = rs.getInt("Giaban");
				int Soluongmua = rs.getInt("Soluongmua");
				
				ChiTietDatHang dh = new ChiTietDatHang(Mahang, Giaban, Soluongmua);
				listDH.add(dh);
			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDH;
	}

	@Override
	public ChiTietDatHang selectById(ChiTietDatHang t) {
		// TODO Auto-generated method stub
		ChiTietDatHang result = null;
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String selectById = "SELECT * FROM ChiTietDatHang WHERE Mahang = '"+t.getMaHang()+"' ";
			System.out.println(selectById);
			ResultSet rs = st.executeQuery(selectById);
			
			while(rs.next()) {
				int Mahang = rs.getInt("Mahang");
				int Giaban = rs.getInt("Giaban");
				int Soluongmua = rs.getInt("Soluongmua");
				
				result = new ChiTietDatHang(Mahang, Giaban, Soluongmua);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ChiTietDatHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<ChiTietDatHang> listDH = new ArrayList<ChiTietDatHang>();
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			String selectCondition = "SELECT * FROM ChiTietDatHang WHERE "+condition;
			System.out.println(selectCondition);
			ResultSet rs = st.executeQuery(selectCondition);
			
			while(rs.next()) {
				int Mahang = rs.getInt("Mahang");
				int Giaban = rs.getInt("Giaban");
				int Soluongmua = rs.getInt("Soluongmua");
				
				ChiTietDatHang dh = new ChiTietDatHang(Mahang, Giaban, Soluongmua);
				listDH.add(dh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDH;
	}

}
