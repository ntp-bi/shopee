package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	
	// Them vao ds 1 phan tu
	public void Them(String masach, String tensach, Long gia, Long soluongmua) {
		for(giohangbean g : ds) {
			if(g.getMasach().equals(masach)) {
				g.setSoluongmua((g.getSoluongmua() + soluongmua));
				return;
			}
			
		}
		ds.add(new giohangbean(masach, tensach, gia, soluongmua));
	}
	
	// Xoa 1 phan tu ra khoi ds
	public void Xoa(String masach) {
		for(giohangbean g : ds) {
			if(g.getMasach().equals(masach)) {
				ds.remove(g);
				return;
			}
		}
	}
	
	// sua lai so luong mua trong mang ds
	public void Capnhapsoluong(String masach, Long soluongmoi) {
		for(giohangbean g : ds) {
			if(g.getMasach().equals(masach)) {
				g.setSoluongmua(soluongmoi);
			}
		}
	}
	
	// Tinh tong thanh tien trong ds
	public long TongTien() {
		int n = ds.size();
		long s = 0;
		
		for(int i = 0; i < n; i++) {
			s += ds.get(i).getThanhtien();
		}
		return s;
	}
	
	public long cartItem() {
		int n = ds.size();
		long s = 0;
		
		for(int i = 0; i < n; i++) {
			s += ds.get(i).getSoluongmua();
		}
		return s;
	}
}