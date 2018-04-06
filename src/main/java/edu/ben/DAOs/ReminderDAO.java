package edu.ben.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.ben.connection.ConnectionPool;
import edu.ben.models.Course;
import edu.ben.models.Reminder;

public class ReminderDAO {

	public static int insert(Reminder r) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "INSERT INTO reminder (assignmentID, type, timestamp) VALUES (?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getAssignmentID());
			ps.setInt(2, r.getType());
			ps.setTimestamp(3, r.getTimestamp());

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

	public static int update(Reminder r) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE reminder ON reminderID='?' SET assignmentID='?', type='?', timestamp='?', active='?', created_on='?';";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getReminderID());
			ps.setInt(2, r.getAssignmentID());
			ps.setInt(3, r.getType());
			ps.setTimestamp(4, r.getTimestamp());
			ps.setBoolean(5, r.isActive());
			ps.setTimestamp(6, r.getCreatedOn());

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

	public static int deactivate(int assignmentID) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE reminder SET active='0' WHERE assignmentID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, assignmentID);

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

	public static int activate(int id) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE reminder ON reminderID='?' SET active='1'";
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

	public static Reminder findByAssignmentID(int assignmentID) {

		Reminder reminder = null;
		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT r.reminderID, r.timestamp, r.created_on, u.email, u.phone_number, r.assignmentID, r.type "
					+ " FROM reminder as r JOIN assignment as a ON r.assignmentID=a.assignmentID JOIN course as c on "
					+ "a.courseID=c.courseID JOIN user as u on c.userID=u.userID"
					+ " WHERE r.assignmentID=? AND r.active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, assignmentID);
			rs = ps.executeQuery();

			String email = "";
			int reminderID, type = -1;
			Timestamp createdOn, timestamp;
			long phoneNumber = 0;

			while (rs.next()) {
				assignmentID = rs.getInt("r.assignmentID");
				email = rs.getString("u.email");
				reminderID = rs.getInt("r.reminderID");
				timestamp = rs.getTimestamp("r.timestamp");
				createdOn = rs.getTimestamp("r.created_on");
				phoneNumber = rs.getLong("u.phone_number");
				type = rs.getInt("r.type");

				reminder = new Reminder(reminderID, assignmentID, type, email, phoneNumber, timestamp, true, createdOn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reminder;
	}

	public static ArrayList<Reminder> getActiveReminders() {

		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT r.reminderID, r.timestamp, r.created_on, u.email, u.phone_number, r.assignmentID, r.type "
					+ " FROM reminder as r JOIN assignment as a ON r.assignmentID=a.assignmentID JOIN course as c on "
					+ "a.courseID=c.courseID JOIN user as u on c.userID=u.userID" + " WHERE r.active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			String email = "";
			int reminderID, assignmentID, type = -1;
			Timestamp createdOn, timestamp;
			long phoneNumber = 0;

			while (rs.next()) {
				assignmentID = rs.getInt("r.assignmentID");
				email = rs.getString("u.email");
				reminderID = rs.getInt("r.reminderID");
				timestamp = rs.getTimestamp("r.timestamp");
				createdOn = rs.getTimestamp("r.created_on");
				phoneNumber = rs.getLong("u.phone_number");
				type = rs.getInt("r.type");

				reminders.add(
						new Reminder(reminderID, assignmentID, type, email, phoneNumber, timestamp, true, createdOn));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reminders;
	}
}
