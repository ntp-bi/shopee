package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();
		// b1 : ket noi vao csdl :qlsach
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tao cau lenh sql
		String sql = "select * from sach";
		// b3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4 truyen tham so vao cau lenh neu co
		// b5: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyet rs
		while (rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");

			ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
		}
		// b7: Dong cac doi tuong
		rs.close();
		kn.cn.close();
		return ds;
	}

	public ArrayList<sachbean> timsachtheoma(String ma) {
		try {
			ArrayList<sachbean> ds = new ArrayList<sachbean>();
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = String.format("select * from sach where masach='" + ma + "'");
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<sachbean> timsachtheoten(String name) {
		try {
			ArrayList<sachbean> ds = new ArrayList<sachbean>();
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = String.format("select * from sach where name like ?");
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + name + "%");
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public sachbean deletesach(String ma) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
			String sql = "delete from sach where masach='" + ma + "'";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			int kq = cmd.executeUpdate();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int updatesach(String masach, String tensach, String tacgia, String soluong, String gia, String maloai,
			String anh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = String.format(
				" update sach set tensach =N'%s', tacgia = '%s', soluong ='%s', gia='%s', maloai='%s', anh='%s' where masach='%s'",
				tensach, tacgia, soluong, gia, maloai, anh, masach);
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}

	public int insertsach(String masach, String tensach, String tacgia, String soluong, String gia, String maloai,
			String anh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "insert into sach(masach, tensach, tacgia, soluong, gia, maloai, anh) values(?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setString(3, tacgia);
		cmd.setString(4, soluong);
		cmd.setString(5, gia);
		cmd.setString(6, maloai);
		cmd.setString(7, anh);
		int kq = cmd.executeUpdate();
		cmd.close();
		return kq;
	}
}
