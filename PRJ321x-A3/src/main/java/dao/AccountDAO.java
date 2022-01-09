package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class AccountDAO {

	public boolean login(String email, String password) throws Exception {

		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();

		String sql = "select count(*) as count from account where user_mail=? and password=?";
		conn = dbc.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();
		int count = 0;

		try {
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			// TODO: handle finally clause
			rs.close();
			stmt.close();
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}

	// them tai khoan vao trong database
	public int create(String email, String password, int accountRole, String userName) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();

		String sql = "insert into Account(user_mail, password, account_role, user_name) values(?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		stmt.setInt(3, accountRole);
		stmt.setString(4, userName);

		int rs = 0;
		try {
			rs = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return rs;
		/*
		 * DBContext dbc = new DBContext(); Connection conn = dbc.getConnection();
		 * 
		 * String sql =
		 * "insert into Account(user_mail, password, account_role, user_name) values(?, ?, ?, ?)"
		 * ; PreparedStatement stmt = conn.prepareStatement(sql); stmt.setString(1,
		 * email ); stmt.setString(2, password); stmt.setInt(3, accountRole);
		 * stmt.setString(4, userName);
		 * 
		 * 
		 * try { stmt.executeUpdate(); } catch (Exception e) { // TODO: handle exception
		 * e.printStackTrace(); } finally { stmt.close(); }
		 * 
		 */
	}

	// kiem tra tai email trong database
	public boolean exists(String email) throws Exception {
		DBContext dbc = new DBContext();
		Connection conn = dbc.getConnection();

		String sql = "select count(*) as count from account where user_mail=?";
		conn = dbc.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);

		ResultSet rs = stmt.executeQuery();
		int count = 0;

		if (rs.next()) {
			count = rs.getInt("count");
		}
		rs.close();
		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}
}
