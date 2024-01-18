package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;

	public ArrayList<sachbean> getsach() throws Exception {
		ds = sdao.getsach();
		return ds;
	}

	public ArrayList<sachbean> TimMa(String maloai) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getMaloai().trim().equals(maloai.trim())) {
				tam.add(s);
			}
		}
		return tam;
	}

	public ArrayList<sachbean> Tim(String key) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getTensach().toLowerCase().trim().contains(key.trim().toLowerCase())
					|| s.getTacgia().toLowerCase().trim().contains(key.trim().toLowerCase())) {
				tam.add(s);
			}
		}
		return tam;
	}

	public ArrayList<sachbean> timsachtheoten(String name) {
		ds = sdao.timsachtheoten(name);
		return ds;
	}

	public ArrayList<sachbean> timsachtheoma(String ma) throws Exception {
		return sdao.timsachtheoma(ma);
	}

	public int updatesach(String masach, String tensach, String tacgia, String soluong, String gia, String maloai,
			String anh) throws Exception {
		return sdao.updatesach(masach, tensach, tacgia, soluong, gia, maloai, anh);
	}

	public int insertsach(String masach, String tensach, String tacgia, String soluong, String gia, String maloai,
			String anh) throws Exception {
		return sdao.insertsach(masach, tensach, tacgia, soluong, gia, maloai, anh);
	}

	public sachbean deletesach(String ma) throws Exception {
		return sdao.deletesach(ma);
	}
}
