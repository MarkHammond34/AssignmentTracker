package edu.ben.DAO;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;

import edu.ben.DAOs.AssignmentDAO;
import edu.ben.connection.ConnectionPool;
import edu.ben.models.Assignment;

public class AssignmentTest {

	@Test
	public void getDailyAssignments() {
		Assignment temp = new Assignment(9, "Sample Assignment", "Sample Desc",
				new Timestamp(System.currentTimeMillis() + 90000), 2, 60, 0);

		int previousCount = AssignmentDAO.getDailyAssignments(2).size();
		AssignmentDAO.insert(temp);
		int newCount = AssignmentDAO.getDailyAssignments(2).size();
		assertEquals(previousCount, newCount);
	}

	@Test
	public void insert() {
		Assignment temp = new Assignment(9, "Sample Assignment1", "Sample Desc",
				new Timestamp(System.currentTimeMillis() + 90000), 2, 60, 0);

		int actual = AssignmentDAO.insert(temp);
		assertEquals(actual, 1);
	}

	@Test
	public void update() {

		Assignment temp = new Assignment(9, "Sample Assignment2", "Sample Desc",
				new Timestamp(System.currentTimeMillis() + 90000), 2, 60, 0);
		AssignmentDAO.insert(temp);

		temp = AssignmentDAO.findByCourseIDAndName(9, "Sample Assignment2");
		temp.setDescription("Different");
		int actual = AssignmentDAO.update(temp);
		assertEquals(actual, 1);
	}

	@Test
	public void deactivate() {

		Assignment temp = new Assignment(9, "Sample Assignment4", "Sample Desc",
				new Timestamp(System.currentTimeMillis() + 90000), 2, 60, 0);
		AssignmentDAO.insert(temp);

		temp = AssignmentDAO.findByCourseIDAndName(9, "Sample Assignment4");
		int actual = AssignmentDAO.deactivate(temp.getAssignmentID());
		assertEquals(actual, 1);

		temp = AssignmentDAO.findByCourseIDAndName(9, "Sample Assignment4");
		if (temp == null) {
			assertEquals(true, true);
		} else {
			assertEquals(false, true);
		}
	}

	@Test
	public void activate() {

		Assignment temp = new Assignment(9, "Sample Assignment5", "Sample Desc",
				new Timestamp(System.currentTimeMillis() + 90000), 2, 60, 0);
		AssignmentDAO.insert(temp);

		temp = AssignmentDAO.findByCourseIDAndName(9, "Sample Assignment5");

		AssignmentDAO.deactivate(temp.getAssignmentID());
		int actual = AssignmentDAO.activate(temp.getAssignmentID());
		assertEquals(actual, 1);

		temp = AssignmentDAO.findByCourseIDAndName(9, "Sample Assignment5");

		if (temp != null) {
			assertEquals(true, true);
		} else {
			assertEquals(false, true);
		}
	}

	@After
	public void clear() {
		DataSource ds = null;
		Connection con = null;

		try {

			ds = ConnectionPool.setUpPool();
			con = ds.getConnection();

			String sql = "DELETE FROM assignment WHERE name LIKE 'Sample Assignment%';";
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
