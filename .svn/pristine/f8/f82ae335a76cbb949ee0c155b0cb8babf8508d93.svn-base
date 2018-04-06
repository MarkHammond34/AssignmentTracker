package edu.ben.DAO;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;

import edu.ben.DAOs.CourseDAO;
import edu.ben.connection.ConnectionPool;
import edu.ben.models.Course;

public class CourseTest {

	@Test
	public void insert() {
		Course temp = new Course(1, 2, "Sample Course1", "NEW DESC2", new Timestamp(System.currentTimeMillis()), true);
		int actual = CourseDAO.insert(temp);
		assertEquals(actual, 1);
	}

	@Test
	public void findByUserID() {

		Course temp = new Course(1, 2, "Sample Course2", "NEW DESC2", new Timestamp(System.currentTimeMillis()), true);
		CourseDAO.insert(temp);
		ArrayList<Course> courses = CourseDAO.findByUserID(1);

		for (Course c : courses) {
			if (c.getName().equals("Sample Course2")) {
				assertEquals(true, true);
			} else {
				assertEquals(false, true);
			}
		}
	}

	@Test
	public void update() {
		Course temp = new Course(1, 2, "Sample Course3", "NEW DESC2", new Timestamp(System.currentTimeMillis()), true);
		CourseDAO.insert(temp);
		ArrayList<Course> courses = CourseDAO.findByUserID(1);

		for (Course c : courses) {
			if (c.getName().equals("Sample Course3")) {
				temp = c;
			}
		}

		temp.setDescription("UPDATED DESC");
		int actual = CourseDAO.update(temp);
		assertEquals(actual, 1);

	}

	@After
	public void clear() {
		DataSource ds = null;
		Connection con = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "DELETE FROM course WHERE name LIKE 'Sample Course%';";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();

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
	}

}
