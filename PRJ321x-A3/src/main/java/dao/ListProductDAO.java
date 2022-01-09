package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

//Các phương thức làm việc với bảne Product
public class ListProductDAO {
	
	public static void main(String[] args) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();
		List<Product> ls = new ArrayList<Product>();
		
		String character = "";
		String sql = "select * from Products where product_name like '" + character + "%'";
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		try {
			ResultSet rs = stmt.executeQuery();			
						
			while (rs.next()) {
				Product pd = new Product();
				pd.setId(Integer.parseInt(rs.getString(1)));
				pd.setName(rs.getString(2));
				pd.setDescription(rs.getString(3));
				pd.setPrice(Float.parseFloat(rs.getString(4)));
				pd.setSrc(rs.getString(5));
				pd.setType(rs.getString(6));
				pd.setBrand(rs.getString(7));
				
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
//				System.out.println(rs.getString(7));
				ls.add(pd);
				
				for (Product product : ls) {
					System.out.print(product.getName());
					System.out.print(product.getBrand());
				}
			}
		} finally {
			// TODO: handle finally clause
			stmt.close();
		}
		
	}
	
	

	//Trả lại danh sách sản phẩm bởi têm sản phẩm
	public List<Product> search(String characters) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();
		List<Product> ls = new ArrayList<Product>();
		
		String sql = "select * from Products where product_name like '" + characters + "%'";
		PreparedStatement stmt = conn.prepareStatement(sql);
				
		try {
			ResultSet rs = stmt.executeQuery();			
						
			while (rs.next()) {
				Product pd = new Product();
				pd.setId(Integer.parseInt(rs.getString(1)));
				pd.setName(rs.getString(2));
				pd.setDescription(rs.getString(3));
				pd.setPrice(Float.parseFloat(rs.getString(4)));
				pd.setSrc(rs.getString(5));
				pd.setType(rs.getString(6));
				pd.setBrand(rs.getString(7));
				
				ls.add(pd);
			}
		} finally {
			// TODO: handle finally clause
			stmt.close();
		}
		
		return ls;
	}
	
	//Lấy sản phẩm
	public Product getProduct(String characters) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();
		Product pd = new Product();
		
		String sql = "select * from Products where product_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, characters);
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pd.setId(Integer.parseInt(rs.getString(1)));
				pd.setName(rs.getString(2));
				pd.setDescription(rs.getString(3));
				pd.setPrice(Float.parseFloat(rs.getString(4)));
				pd.setSrc(rs.getString(5));
				pd.setType(rs.getString(6));
				pd.setBrand(rs.getString(7));
			}
			
		} finally {
			// TODO: handle finally clause
			stmt.close();
		}
		
		return pd;		
	}
}
