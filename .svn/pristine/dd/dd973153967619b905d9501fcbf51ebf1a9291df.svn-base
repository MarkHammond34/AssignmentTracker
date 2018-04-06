package edu.ben.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import edu.ben.models.Assignment;

public class Dates {

	public static ArrayList<Assignment> getSundayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp monday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> sundayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(monday)) {
				sundayAssignments.add(a);
			}
		}
		return sundayAssignments;
	}

	public static ArrayList<Assignment> getMondayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp monday = new Timestamp(c.getTimeInMillis());

		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp tuesday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> mondayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(tuesday) && a.getDue().after(monday)) {
				mondayAssignments.add(a);
			}
		}
		return mondayAssignments;
	}

	public static ArrayList<Assignment> getTuesdayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp wednesday = new Timestamp(c.getTimeInMillis());

		c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp tuesday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> tuesdayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(wednesday) && a.getDue().after(tuesday)) {
				tuesdayAssignments.add(a);
			}
		}
		return tuesdayAssignments;
	}

	public static ArrayList<Assignment> getWednesdayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp wednesday = new Timestamp(c.getTimeInMillis());

		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp thursday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> wednesdayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(thursday) && a.getDue().after(wednesday)) {
				wednesdayAssignments.add(a);
			}
		}
		return wednesdayAssignments;
	}

	public static ArrayList<Assignment> getThursdayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp friday = new Timestamp(c.getTimeInMillis());

		c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp thursday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> thursdayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(friday) && a.getDue().after(thursday)) {
				thursdayAssignments.add(a);
			}
		}
		return thursdayAssignments;
	}

	public static ArrayList<Assignment> getFridayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp friday = new Timestamp(c.getTimeInMillis());

		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp saturday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> fridayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().before(saturday) && a.getDue().after(friday)) {
				fridayAssignments.add(a);
			}
		}
		return fridayAssignments;
	}

	public static ArrayList<Assignment> getSaturdayAssignments(ArrayList<Assignment> assignments) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Timestamp saturday = new Timestamp(c.getTimeInMillis());

		ArrayList<Assignment> saturdayAssignments = new ArrayList<Assignment>();

		for (Assignment a : assignments) {
			if (a.getDue().after(saturday)) {
				saturdayAssignments.add(a);
			}
		}
		return saturdayAssignments;
	}
}