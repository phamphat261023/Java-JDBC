package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {

	public static UserDAO getIntances() {
		return new UserDAO();
	}
	
	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		int insertResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String insertSql = "INSERT INTO users(id, username, password, name)"
					+ "VALUES ( ?, ?, ?, ? )";
			PreparedStatement st = c.prepareStatement(insertSql);
			st.setInt(1, t.getId());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(3, t.getName());
			
			insertResult = st.executeUpdate();
			System.out.println(insertSql);
			System.out.println("Co "+insertResult+" dong duoc them vao database ");
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertResult;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		int updateResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String updateSql = "UPDATE users "+
					 " SET " +
					 " name= ?"+
					 " WHERE id = ?";
			PreparedStatement pst = c.prepareStatement(updateSql);
			pst.setString(1, t.getName());
			pst.setInt(2, t.getId());
			
			updateResult = pst.executeUpdate();
			System.out.println(updateSql);
			System.out.println("Co "+updateResult+" dong duoc cap nhat trong database ");
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateResult;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		int deleteResult = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String deleteSql = "DELETE from users "+
					 " WHERE id=?";
			PreparedStatement pst = c.prepareStatement(deleteSql);
			pst.setInt(1, t.getId());
			
			deleteResult = pst.executeUpdate();
			System.out.println(deleteSql);
			System.out.println("Co "+deleteResult+" dong bi xoa trong database");
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteResult;
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(User t) {
		// TODO Auto-generated method stub
		User findById = null;
		try {
			Connection c = JDBCUtil.getConnection();
			String selectById = "SELECT * FROM users WHERE id = ? ";
			PreparedStatement pst = c.prepareStatement(selectById);
			pst.setInt(1, t.getId());
			
			System.out.println(selectById);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				
				findById = new User(id, username, password, name);
			}
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findById;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
