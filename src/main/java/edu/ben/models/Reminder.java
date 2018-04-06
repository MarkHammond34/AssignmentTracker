package edu.ben.models;

import java.sql.Timestamp;

public class Reminder {

	public static final int SMS = 100;
	public static final int EMAIL = 200;

	private int reminderID;
	private int assignmentID;
	private int type;
	private Timestamp timestamp;
	private boolean active;
	private Timestamp createdOn;
	private long delay;
	private String email;
	private long phoneNumber;
	private String name;
	private int timeBefore;

	public Reminder(int reminderID, int assignmentID, int type, String email, long phoneNumber, Timestamp timestamp,
			boolean active, Timestamp createdOn) {
		this.reminderID = reminderID;
		this.assignmentID = assignmentID;
		delay = timestamp.getTime() - System.currentTimeMillis();
		this.type = type;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.timestamp = timestamp;
		this.active = active;
		this.createdOn = createdOn;
	}

	public Reminder(int assignmentID, int type, String email, long phoneNumber, Timestamp timestamp) {
		this.reminderID = -1;
		this.assignmentID = assignmentID;
		delay = timestamp.getTime() - System.currentTimeMillis();
		this.type = type;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.timestamp = timestamp;
		this.active = true;
		this.createdOn = null;
	}

	public void setTimeBefore(int timeBefore) {
		this.timeBefore = timeBefore;
	}

	public String getName() {
		return name;
	}

	public int getTimeBefore() {
		return timeBefore;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public int getReminderID() {
		return reminderID;
	}

	public void setReminderID(int reminderID) {
		this.reminderID = reminderID;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentID;
		result = prime * result + reminderID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		if (assignmentID != other.assignmentID)
			return false;
		if (reminderID != other.reminderID)
			return false;
		return true;
	}

}
