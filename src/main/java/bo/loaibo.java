package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;

	public ArrayList<loaibean> getloai() throws Exception {
		return ldao.getloai();
	}

	public loaibean deleteloai(String ma) {
		return ldao.deleteloai(ma);
	}

	public int updateloai(String maloai, String tenloai) throws Exception {
		return ldao.updateloai(maloai, tenloai);
	}

	public int insertloai(String maloai, String tenloai) throws Exception {
		return ldao.insertloai(maloai, tenloai);
	}

	public ArrayList<loaibean> timloaitheoma(String ma) {
		ds = ldao.timloaitheoma(ma);
		return ds;
	}
}
