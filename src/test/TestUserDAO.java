package test;

import dao.UserDAO;
import model.User;

public class TestUserDAO {
	public static void main(String[] args) {
		//insert
//		User user1 = new User(1,"phamphat2610232@gmail.com", "phat26102003", "Pham Ngoc Phat");
//		User user2 = new User(2,"quang221012@gmail.com", "quang123", "Nguyen Van Quang");
//		User user3 = new User(3,"ducpham@gmail.com", "duc123", "Pham Quang Duc");
//		UserDAO.getIntances().insert(user3);
		
		//update
//		User user3 = new User(3,"ducpham@gmail.com", "duc123", "Tran Thanh Tai");
//		UserDAO.getIntances().update(user3);
		
		//delete
		User user2 = new User(2,"quang221012@gmail.com", "quang123", "Nguyen Van Quang");
		UserDAO.getIntances().delete(user2);
		
		//Select by Id
//		User findById = new User();
//		findById.setId(1);
//		User user = UserDAO.getIntances().selectById(findById);
//		System.out.println(user);
//		
		//Hacker attack - dang su dung statements
//		User findById = new User(1,"x\' or 1=1; -- ","","");
//		User user = UserDAO.getIntances().selectById(findById);
//		System.out.println(user);
	}
}
