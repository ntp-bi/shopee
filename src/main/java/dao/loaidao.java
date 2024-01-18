package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		// B1: KET NOI VAO CSDL: QLSach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// B2: TAO CAU LENH SQL
		String sql = "SELECT * FROM loai";
		// B3: TAO CAU LENH
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// B4: TRUYEN THAM SO VAO CAU LENH NEU CO
		// B5: THUC HIEN CAU LENH
		ResultSet rs = cmd.executeQuery();
		// B6: DUYET rs
		while (rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		// B7: ĐÓNG CAC DOI TUONG
		rs.close();
		kn.cn.close();
		return ds;
	}

	public loaibean deleteloai(String ma) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "delete from loai where maloai='" + ma + "'";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			int kq = cmd.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int updateloai(String maloai, String tenloai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = String.format(" update loai set tenloai =N'%s' where maloai='%s'", tenloai, maloai);
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}

	public int insertloai(String maloai, String tenloai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "insert into loai(maloai,tenloai) values(?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}

	public ArrayList<loaibean> timloaitheoma(String mal) {
		try {
			ArrayList<loaibean> ds = new ArrayList<loaibean>();
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = String.format("select * from loai where maloai='" + mal + "'");
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				ds.add(new loaibean(maloai, tenloai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
