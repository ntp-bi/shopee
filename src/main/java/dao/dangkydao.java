package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class dangkydao {
	public int Dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String sql = "INSERT INTO KhachHang(hoten,diachi,sodt,email,tendn,pass) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setString(1,hoten);
		cmd.setString(2,diachi);
		cmd.setString(3,sodt);
		cmd.setString(4,email);
		cmd.setString(5,tendn);
		cmd.setString(6,pass);
		
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public boolean ktdk(String tendn) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String sql = "Select * From khachhang where tendn=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		cmd.setString(1, tendn);
		
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			cmd.close();
			kn.cn.close();
			return false;
		} else {
			cmd.close();
			kn.cn.close();
			return true;
		}
		
		
		
	}
}
