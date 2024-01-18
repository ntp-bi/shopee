package bo;

import java.util.ArrayList;

import bean.AdminXacNhanbean;
import dao.chitietHddao;

public class chitietHdbo {
	chitietHddao cthddao = new chitietHddao();

	public int Them(String MaSach, long SoLuongMua, long MaHoaDon) throws Exception {
		return cthddao.Them(MaSach, SoLuongMua, MaHoaDon);
	}

	public ArrayList<AdminXacNhanbean> getXacNhan() throws Exception {
		return cthddao.getXacNhan();
	}

	public int XacNhan(long mct) throws Exception {
		return cthddao.XacNhan(mct);
	}

	public int Xoa() throws Exception {
		return cthddao.Xoa();
	}
}
