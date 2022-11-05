package model;

public class KhoHang {
	private int maHang;
	private String tenHang;
	private int sl;
	
	public KhoHang() {
		super();
	}
	
	public KhoHang(int maHang, String tenHang, int sl) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.sl = sl;
	}

	public int getMaHang() {
		return maHang;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}

	@Override
	public String toString() {
		return "KhoHang [maHang=" + maHang + ", tenHang=" + tenHang + ", sl=" + sl + "]";
	}
	
}
