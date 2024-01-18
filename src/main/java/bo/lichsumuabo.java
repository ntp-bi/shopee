package bo;

import java.util.ArrayList;

import bean.lichsumuabean;
import dao.lichsumuadao;

public class lichsumuabo {
	lichsumuadao lsmuadao = new lichsumuadao();
	ArrayList<lichsumuabean> ds;

	public ArrayList<lichsumuabean> getLichsumuahang(long makh) throws Exception {
		return lsmuadao.getLichsumuahang(makh);
	}
}
