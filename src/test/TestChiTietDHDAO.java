package test;

import java.util.ArrayList;

import dao.ChiTietDHDAO;
import model.ChiTietDatHang;

public class TestChiTietDHDAO {
	public static void main (String[] args) {
		
		//insert
//		ChiTietDatHang dh1 = new ChiTietDatHang(111, 50000, 3);
//		ChiTietDatHang dh2 = new ChiTietDatHang(222, 90000, 6);
//		ChiTietDatHang dh3 = new ChiTietDatHang(333, 70000, 5);
//		ChiTietDatHang dh4 = new ChiTietDatHang(444, 100000, 2);
//		ChiTietDHDAO.getInstance().insert(dh4);
		
		//update
//		ChiTietDatHang dh1 = new ChiTietDatHang(111, 60000, 4);
//		ChiTietDHDAO.getInstance().update(dh1);
		
		//delete
//		ChiTietDatHang dh4 = new ChiTietDatHang(444, 100000, 2);
//		ChiTietDHDAO.getInstance().delete(dh4);
		
		//Select all
		ArrayList<ChiTietDatHang> listDH = ChiTietDHDAO.getInstance().selectAll();
		for(ChiTietDatHang dh : listDH) {
			System.out.println(dh.toString());
		}
		
		//Select by id
		System.out.println("--------------------------------------");
		ChiTietDatHang findById = new ChiTietDatHang();
		findById.setMaHang(222);
		ChiTietDatHang dhById = ChiTietDHDAO.getInstance().selectById(findById);
		System.out.println("Chi tiet dat hang co ma can tim la:  " + dhById);
		
		//Select by condition
		System.out.println("--------------------------------------");
		System.out.println("Chi tiet dat hang co gia ban > 60000");
		
		ArrayList<ChiTietDatHang> listDHByCondition = ChiTietDHDAO.getInstance().selectByCondition("Giaban > 60000");
		for(ChiTietDatHang dh : listDHByCondition) {
			System.out.println(dh.toString());
		}
	}
}
