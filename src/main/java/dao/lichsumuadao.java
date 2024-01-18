package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsumuabean;

public class lichsumuadao {
public ArrayList<lichsumuabean>getLichsumuahang(long makhachhang)throws Exception {
		
		ArrayList<lichsumuabean> lsm = new ArrayList<lichsumuabean>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String sql = "select * from Vlichsu where makh=? ";
	       
		PreparedStatement cmd = kn.cn.prepareStatement(sql);	
		cmd.setLong(1, makhachhang);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long soluong = rs.getLong("soluong"); 
			long gia = rs.getLong("gia");
			long thanhtien = rs.getLong("thanhtien");
			String masach = rs.getString("masach");
			long makh = rs.getLong("makh");
			long soluongmua = rs.getLong("soluongmua");
			Boolean damua = rs.getBoolean("damua");
			String anh = rs.getString("anh");
			String tensach = rs.getString("tensach");
			
			lsm.add(new lichsumuabean(soluong, gia, thanhtien, masach, makh, soluongmua, damua, anh, tensach));
	
		}
		cmd.close();
		kn.cn.close();
		return lsm;
	}
}
