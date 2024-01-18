package bean;

public class lichsumuabean {
	private long soluong;
	private long gia;
	private long thanhtien;
	private String masach;
	private long makh;
	private long soluongmua;
	private Boolean damua;
	private String anh;
	private String tensach;

	public lichsumuabean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public lichsumuabean(long soluong, long gia, long thanhtien, String masach, long makh, long soluongmua,
			Boolean damua, String anh, String tensach) {
		super();
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.masach = masach;
		this.makh = makh;
		this.soluongmua = soluongmua;
		this.damua = damua;
		this.anh = anh;
		this.tensach = tensach;
	}

	public long getSoluong() {
		return soluong;
	}

	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public long getSoluongmua() {
		return soluongmua;
	}

	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}

	public Boolean getDamua() {
		return damua;
	}

	public void setDamua(Boolean damua) {
		this.damua = damua;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

}
