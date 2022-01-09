package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

//Các phương thức làm việc với bảng Order
public class OrdersDAO {

	/*chèn thông tin của Đơn hàng vào nguồn dữ liệu
	 * Thông tin của giỏ hàng và thông tin cảu người mua đặt hàng
	 * */
	public void insertOrder(Orders o, Cart c) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();
		PreparedStatement stmt;
		String discount = "";
		discount = o.getDiscount();
		
		String str =  "insert into orders (user_mail, order_status, order_discount_code, order_address) values ('queca',2, '', 'HaNoi')";
		String sql =  "insert into orders (user_mail, order_status, order_discount_code, order_address) values ('"+ o.getUserMail() +"',2, '"+discount+"', '"+o.getAddress()+"')";
		
		stmt = conn.prepareStatement(sql);
		
		int status = 0;
		try {
			status = stmt.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			stmt.close();
		}
		
		int orderId = 0;
		if (status == 1) {
			sql = "select top(1) order_id as id from Orders order by order_id desc";
			stmt = conn.prepareStatement(sql);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					orderId = rs.getInt("id");		
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				stmt.close();
			}
		}
		
		
		List<Product> list = c.getItems();
		
		
		if (orderId != 0) {
			for (Product product : list) {
				sql = "insert into Orders_detail (order_id, product_id, amount_product, price_product) "
						+ "values (" + orderId + ", " + product.getId() + ", " + product.getNumber()  + ", " + product.getPrice() + ")";
				stmt = conn.prepareStatement(sql);
				try {
					stmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					stmt.close();
				}
			}
			
		}
		
	}
		
}
