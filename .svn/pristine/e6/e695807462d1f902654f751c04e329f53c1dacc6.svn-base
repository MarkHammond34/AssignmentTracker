package edu.ben.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import edu.ben.connection.ConnectionPool;
import edu.ben.models.User;

public class UserDAO {

	public static int insert(User u) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "INSERT INTO user (first_name, last_name, email, password, phone_number) VALUES (?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setLong(5, u.getPhoneNumber());
			results = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	public static int update(User u) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE user SET first_name=?, last_name=?, email=?, phone_number=? WHERE userID=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getEmail());
			ps.setLong(4, u.getPhoneNumber());
			ps.setInt(5, u.getUserID());

			results = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	public static int deactivate(int id) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE user ON userID='?' SET active='0'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			results = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	public static User findByEmail(String email) {

		User user = null;

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM user WHERE email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			String firstName, lastName, password;
			int userID;
			long phoneNumber;
			boolean active;
			Timestamp createdOn;

			while (rs.next()) {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				password = rs.getString("password");
				phoneNumber = rs.getLong("phone_number");
				email = rs.getString("email");
				active = rs.getBoolean("active");
				userID = rs.getInt("userID");
				createdOn = rs.getTimestamp("created_on");

				user = new User(userID, firstName, lastName, email, password, phoneNumber, createdOn, active);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	public static int activate(int id) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE user ON userID='?' SET active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			results = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

}
