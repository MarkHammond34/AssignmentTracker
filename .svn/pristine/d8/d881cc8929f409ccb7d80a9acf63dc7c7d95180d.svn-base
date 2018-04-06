package edu.ben.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.*;

import edu.ben.connection.ConnectionPool;
import edu.ben.models.Assignment;

public class AssignmentDAO {

	public static int insert(Assignment a) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "INSERT INTO assignment (courseID, name, description, due, difficulty, time_required) VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getCourseID());
			ps.setString(2, a.getName());
			ps.setString(3, a.getDescription());
			ps.setTimestamp(4, a.getDue());
			ps.setInt(5, a.getDifficulty());
			ps.setInt(6, a.getTimeRequired());

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

	public static int update(Assignment a) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE assignment SET name=?, description=?, due=?, difficulty=?, time_required=? WHERE assignmentID=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getDescription());
			ps.setTimestamp(3, a.getDue());
			ps.setInt(4, a.getDifficulty());
			ps.setInt(5, a.getTimeRequired());
			ps.setInt(6, a.getAssignmentID());

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

	public static Assignment findByCourseIDAndName(int courseID, String assignmentName) {

		Assignment assignment = null;

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM assignment WHERE courseID=? AND name=? AND active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, courseID);
			ps.setString(2, assignmentName);
			rs = ps.executeQuery();

			int assignmentID, difficulty, timeRequired, priority = -1;
			String name, desc, courseName = "";
			boolean active = false;
			Timestamp due, createdOn = null;

			while (rs.next()) {

				assignmentID = rs.getInt("assignmentID");
				courseID = rs.getInt("courseID");
				name = rs.getString("name");
				courseName = rs.getString("name");
				desc = rs.getString("description");
				due = rs.getTimestamp("due");
				difficulty = rs.getInt("difficulty");
				timeRequired = rs.getInt("time_required");
				priority = rs.getInt("priority");
				active = rs.getBoolean("active");
				createdOn = rs.getTimestamp("created_on");

				assignment = new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty,
						timeRequired, priority, active, createdOn);
				assignment.setReminder(ReminderDAO.findByAssignmentID(assignmentID));
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
		return assignment;

	}

	public static Assignment findByAssignmentID(int assignmentID) {

		Assignment assignment = null;

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM assignment WHERE assignmentID=? AND active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, assignmentID);
			rs = ps.executeQuery();

			int courseID, difficulty, timeRequired, priority = -1;
			String name, desc, courseName = "";
			boolean active = false;
			Timestamp due, createdOn = null;

			while (rs.next()) {

				assignmentID = rs.getInt("assignmentID");
				courseID = rs.getInt("courseID");
				name = rs.getString("name");
				courseName = rs.getString("name");
				desc = rs.getString("description");
				due = rs.getTimestamp("due");
				difficulty = rs.getInt("difficulty");
				timeRequired = rs.getInt("time_required");
				priority = rs.getInt("priority");
				active = rs.getBoolean("active");
				createdOn = rs.getTimestamp("created_on");

				assignment = new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty,
						timeRequired, priority, active, createdOn);
				assignment.setReminder(ReminderDAO.findByAssignmentID(assignmentID));
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
		return assignment;

	}

	public static int deactivate(int id) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE assignment SET active='0' WHERE assignmentID=?";
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

	public static int activate(int id) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE assignment SET active=1 WHERE assignmentID=?";
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

	public static ArrayList<Assignment> getDailyAssignments(int userID) {

		ArrayList<Assignment> dailyAssignments = new ArrayList<Assignment>();

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM assignment INNER JOIN course ON course.courseID=assignment.courseID "
					+ "WHERE course.userID=? AND assignment.active=1 AND DAY(assignment.due) = DAY(CURDATE());";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();

			int assignmentID, courseID, difficulty, timeRequired, priority = -1;
			String name, desc, courseName = "";
			boolean active = false;
			Timestamp due, createdOn = null;

			while (rs.next()) {

				assignmentID = rs.getInt("assignment.assignmentID");
				courseID = rs.getInt("assignment.courseID");
				name = rs.getString("assignment.name");
				courseName = rs.getString("course.name");
				desc = rs.getString("assignment.description");
				due = rs.getTimestamp("assignment.due");
				difficulty = rs.getInt("assignment.difficulty");
				timeRequired = rs.getInt("assignment.time_required");
				priority = rs.getInt("assignment.priority");
				active = rs.getBoolean("assignment.active");
				createdOn = rs.getTimestamp("assignment.created_on");

				dailyAssignments.add(new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty,
						timeRequired, priority, active, createdOn));
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

		return dailyAssignments;

	}

	public static ArrayList<Assignment> findByCourseID(int courseID) {

		ArrayList<Assignment> assignments = new ArrayList<Assignment>();

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM assignment WHERE courseID=? AND active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, courseID);
			rs = ps.executeQuery();

			int assignmentID, difficulty, timeRequired, priority = -1;
			String name, desc, courseName = "";
			boolean active = false;
			Timestamp due, createdOn = null;

			while (rs.next()) {

				assignmentID = rs.getInt("assignmentID");
				courseID = rs.getInt("courseID");
				name = rs.getString("name");
				courseName = rs.getString("name");
				desc = rs.getString("description");
				due = rs.getTimestamp("due");
				difficulty = rs.getInt("difficulty");
				timeRequired = rs.getInt("time_required");
				priority = rs.getInt("priority");
				active = rs.getBoolean("active");
				createdOn = rs.getTimestamp("created_on");

				assignments.add(new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty,
						timeRequired, priority, active, createdOn));
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
		return assignments;
	}

	public static ArrayList<Assignment> getWeeklyAssignments(int userID) {

		ArrayList<Assignment> weeklyAssignments = new ArrayList<Assignment>();

		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM assignment INNER JOIN course ON course.courseID=assignment.courseID "
					+ "WHERE course.userID=? AND assignment.active=1 AND YEARWEEK(assignment.due) = YEARWEEK(CURDATE());";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();

			int assignmentID, courseID, difficulty, timeRequired, priority = -1;
			String name, desc, courseName = "";
			boolean active = false;
			Timestamp due, createdOn = null;

			while (rs.next()) {

				assignmentID = rs.getInt("assignment.assignmentID");
				courseID = rs.getInt("assignment.courseID");
				name = rs.getString("assignment.name");
				courseName = rs.getString("course.name");
				desc = rs.getString("assignment.description");
				due = rs.getTimestamp("assignment.due");
				difficulty = rs.getInt("assignment.difficulty");
				timeRequired = rs.getInt("assignment.time_required");
				priority = rs.getInt("assignment.priority");
				active = rs.getBoolean("assignment.active");
				createdOn = rs.getTimestamp("assignment.created_on");

				weeklyAssignments.add(new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty,
						timeRequired, priority, active, createdOn));
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

		return weeklyAssignments;

	}
}