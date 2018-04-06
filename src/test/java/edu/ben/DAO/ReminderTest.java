package edu.ben.DAO;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import edu.ben.DAOs.ReminderDAO;
import edu.ben.models.Reminder;
import edu.ben.util.NotificationRunner;

public class ReminderTest {

	// @Test
	public void test() {
		ReminderDAO.insert(new Reminder(1, Reminder.EMAIL, "markhammond1010@yahoo.com", 6307462519L,
				new Timestamp(System.currentTimeMillis())));
	}

	// @Test
	public void test2() {
		Reminder r = ReminderDAO.findByAssignmentID(1);
		System.out.println(r.getDelay());
	}

	@Test
	public void test3() {

		NotificationRunner.main(null);
	}
}
