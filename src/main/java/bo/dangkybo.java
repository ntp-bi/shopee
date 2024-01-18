package bo;


import dao.dangkydao;

public class dangkybo {
	dangkydao dkdao = new dangkydao();
	public int Dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass) throws Exception {
		return dkdao.Dangky(hoten, diachi, sodt, email, tendn, pass);
	}
	public boolean ktdk(String tendn) throws Exception {
		return dkdao.ktdk(tendn);
	}
}
