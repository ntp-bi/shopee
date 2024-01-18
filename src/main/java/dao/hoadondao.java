package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadondao {
	public int Them(long makh) throws Exception{
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "INSERT INTO hoadon(makh, NgayMua, damua) values(?,?,0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		
		Date n1 = new Date(); // Lay ngay gio hien tai
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String st = dd.format(n1);
		
		Date n2 = dd.parse(st);
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	
	public long MaxHd() throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		
		String sql = "SELECT MAX(MaHoaDon) as MaxHd FROM hoadon";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		
		if(rs.next()) {
			max = rs.getLong("MaxHd");
		}
		cmd.close();
		kn.cn.close();
		return max;
	}
}
