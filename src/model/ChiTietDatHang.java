package model;

public class ChiTietDatHang {
	private int maHang;
	private int giaBan;
	private int slMua;
	
	public ChiTietDatHang() {
		super();
	}

	public ChiTietDatHang(int maHang, int giaBan, int slMua) {
		super();
		this.maHang = maHang;
		this.giaBan = giaBan;
		this.slMua = slMua;
	}

	public int getMaHang() {
		return maHang;
	}

	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	public int getSlMua() {
		return slMua;
	}

	public void setSlMua(int slMua) {
		this.slMua = slMua;
	}
	@Override
	public String toString() {
		return "ChiTietDatHang [maHang=" + maHang + ", giaBan=" + giaBan + ", slMua=" + slMua + "]";
	}

}
