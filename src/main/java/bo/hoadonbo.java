package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();

	public int Them(long makh) throws Exception {
		return hddao.Them(makh);
	}

	public long MaxHd() throws Exception {
		return hddao.MaxHd();
	}
}
