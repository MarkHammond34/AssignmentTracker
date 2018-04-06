package edu.ben.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import edu.ben.connection.ConnectionPool;
import edu.ben.models.Course;
import java.util.ArrayList;

public class CourseDAO {

	public static int insert(Course c) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "INSERT INTO course (userID, name, description) VALUES (?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, c.getUserID());
			ps.setString(2, c.getName());
			ps.setString(3, c.getDescription());

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

	public static int update(Course c) {

		DataSource ds = null;
		Connection con = null;

		int results = -1;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "UPDATE course SET name=?, description=? WHERE courseID=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getCourseID());

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

			String sql = "UPDATE course ON courseID='?' SET active='0'";
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

			String sql = "UPDATE course SET active='1' WHERE userID=?";
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

	public static ArrayList<Course> findByUserID(int userID) {

		ArrayList<Course> courses = new ArrayList<Course>();
		DataSource ds = null;
		Connection con = null;
		ResultSet rs = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "SELECT * FROM course WHERE userID=? AND active='1'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();

			String name, desc = "";
			int courseID = -1;
			Timestamp createdOn;

			while (rs.next()) {
				name = rs.getString("name");
				desc = rs.getString("description");
				courseID = rs.getInt("courseID");
				createdOn = rs.getTimestamp("created_on");

				Course course = new Course(userID, courseID, name, desc, createdOn, true);
				course.setAssignments(AssignmentDAO.findByCourseID(courseID));
				courses.add(course);
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
		return courses;
	}
}
