package edu.ben.models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Course {

	private int courseID;
	private String name;
	private String description;
	private Timestamp createdOn;
	private boolean active;
	private int userID;
	private ArrayList<Assignment> assignments;

	public Course(int userID, int courseID, String name, String desc, Timestamp createdOn, boolean active) {
		this.userID = userID;
		this.courseID = courseID;
		this.name = name;
		this.description = desc;
		this.createdOn = createdOn;
		this.active = active;
	}

	public Course(int userID, String name, String desc) {
		this.userID = userID;
		this.courseID = -1;
		this.name = name;
		this.description = desc;
		this.createdOn = null;
		this.active = true;
	}

	public int getAssignmentCount() {
		if (assignments != null) {
			return assignments.size();
		}
		return 0;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
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

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseID;
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
		Course other = (Course) obj;
		if (courseID != other.courseID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}