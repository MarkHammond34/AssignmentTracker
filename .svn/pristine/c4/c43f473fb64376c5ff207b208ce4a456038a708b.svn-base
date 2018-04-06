package edu.ben.models;

import java.sql.Timestamp;

public class Assignment implements Comparable<Assignment> {

	private int assignmentID;
	private int courseID;
	private String courseName;
	private String name;
	private String description;
	private Timestamp due;
	private int difficulty;
	private int timeRequired;
	private boolean active;
	private Timestamp createdOn;
	private int priority;
	private Reminder reminder;

	public Assignment(int assignmentID, int courseID, String name, String courseName, String desc, Timestamp due,
			int diff, int timeRequired, int priority, boolean active, Timestamp createdOn) {
		this.courseID = courseID;
		this.assignmentID = assignmentID;
		this.name = name;
		this.courseName = courseName;
		this.description = desc;
		this.due = due;
		this.difficulty = diff;
		this.timeRequired = timeRequired;
		this.priority = priority;
		this.active = active;
		this.createdOn = createdOn;
	}

	public Assignment(int courseID, String name, String desc, Timestamp due, int diff, int timeRequired, int priority) {
		this.courseID = courseID;
		this.assignmentID = -1;
		this.name = name;
		this.description = desc;
		this.due = due;
		this.difficulty = diff;
		this.timeRequired = timeRequired;
		this.priority = priority;
		this.active = true;
		this.createdOn = null;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDue() {
		return due;
	}

	public void setDue(Timestamp due) {
		this.due = due;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Assignment other = (Assignment) obj;
		if (assignmentID != other.assignmentID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Assignment compAssign) {
		return priority - compAssign.priority;
	}

}
