package bean;

public class AdminXacNhanbean {
	private long MaChiTietHD;
	private String hoten;
	private String tensach;
	private long gia;
	private long SoLuongMua;
	private String thanhtien;
	private boolean damua;

	public AdminXacNhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminXacNhanbean(long maChiTietHD, String hoten, String tensach, long gia, long soLuongMua, String thanhtien,
			boolean damua) {
		super();
		MaChiTietHD = maChiTietHD;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		SoLuongMua = soLuongMua;
		this.thanhtien = thanhtien;
		this.damua = damua;
	}

	public long getMaChiTietHD() {
		return MaChiTietHD;
	}

	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}

	public String getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(String thanhtien) {
		this.thanhtien = thanhtien;
	}

	public boolean isDamua() {
		return damua;
	}

	public void setDamua(boolean damua) {
		this.damua = damua;
	}

	@Override
	public String toString() {
		return "AdminXacNhanbean [MaChiTietHD=" + MaChiTietHD + ", hoten=" + hoten + ", tensach=" + tensach + ", gia="
				+ gia + ", SoLuongMua=" + SoLuongMua + ", thanhtien=" + thanhtien + ", damua=" + damua + "]";
	}

}
