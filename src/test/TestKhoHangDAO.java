package test;

import java.util.ArrayList;

import dao.KhoHangDAO;
import model.KhoHang;

public class TestKhoHangDAO {
	public static void main (String[] args) {
		// Test insert
//		KhoHang kh1 = new KhoHang(222, "Xe may", 10 );
//		KhoHang kh2 = new KhoHang(333, "Xe dap", 20);
//		KhoHang kh5 = new KhoHang(555, "Tu lanh", 60);
//		KhoHang kh6 = new KhoHang(666, "Ti vi", 70);
////		
//		KhoHangDAO.getInstance().insert(kh6);
		
		//Test update
//		KhoHang kh6 = new KhoHang(666, "Tivi Sony", 75);
//		KhoHangDAO.getInstance().update(kh6);
//		
		//Test delete
//		
//		KhoHang kh6 = new KhoHang(666, "Tivi Sony", 75);
//		KhoHangDAO.getInstance().delete(kh6);
		
		ArrayList<KhoHang> listKH = KhoHangDAO.getInstance().selectAll();
		for(KhoHang khohang : listKH) {
			System.out.println(khohang.toString());
		}
		
		System.out.println("----------------------------");
		KhoHang findById = new KhoHang();
		findById.setMaHang(333);
		KhoHang kh2 = KhoHangDAO.getInstance().selectById(findById);
		System.out.println(kh2);
		
		System.out.println("----------------------------");
		System.out.println("Hang co so luong lon hon 30");
		ArrayList<KhoHang> list = KhoHangDAO.getInstance().selectByCondition("Soluong > 30");
		for(KhoHang kh : list) {
			System.out.println(kh.toString());
		}
	}
}
