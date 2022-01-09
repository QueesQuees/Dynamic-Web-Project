package model;

import java.util.ArrayList;
import java.util.List;

/*Chứa tthoong tin về một đơn hàng hiện tại*/
public class Cart {
	
	private List<Product> items; //danh sách sản phẩm trong giỏ hàng
	
	public Cart() {
		items = new ArrayList<Product>();
	}
	
	//Thêm một sản phẩm mới vào giỏ hàng
	public void add(Product ci) {
		for (Product x : items) {
			if(ci.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(ci);
	}
	
	//Xóa một sản phẩm trong giỏ hàng
	public void remove (int id) {
		for (Product x: items) {
			if (x.getId() == id) {
				items.remove(x);
				return;
			}
		}
	}
	
	//trả lại tổng giá trị sản phẩm
	public double getAmount() {
		double s = 0;
		for (Product x: items) {
			s += x.getPrice() * x.getNumber();
		}
		return Math.round(s * 100.0) / 100.0;
	}
	
	//Trả lại danh sách sản phẩm
	public List<Product> getItems () {
		return items; 
	}
}
