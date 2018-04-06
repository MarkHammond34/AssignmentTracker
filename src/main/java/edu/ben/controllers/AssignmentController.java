package edu.ben.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ben.DAOs.AssignmentDAO;
import edu.ben.DAOs.CourseDAO;
import edu.ben.DAOs.ReminderDAO;
import edu.ben.models.Assignment;
import edu.ben.models.Course;
import edu.ben.models.Reminder;
import edu.ben.models.User;
import edu.ben.util.Dates;
import edu.ben.util.NotificationRunner;
import edu.ben.util.Priority;

@Controller
public class AssignmentController extends BaseController {

	public AssignmentController() {
		super();
	}

	@GetMapping("/mark-as-done")
	public String markAsDone(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login to Alter An Assignment");
			return "login";
		} else {

			int assignmentID = Integer.parseInt(request.getParameter("id"));

			if (AssignmentDAO.deactivate(assignmentID) == 1) {
				addSuccessMessage("Great Job!");
			}
		}

		setMessagesInModel(m);
		return "redirect:/home";
	}

	@GetMapping("/weekly-assignments")
	public String weeklyAssignments(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login to View Assignments");
			return "login";
		} else {

			ArrayList<Assignment> weeklyAssignments = AssignmentDAO.getWeeklyAssignments(user.getUserID());

			ArrayList<Assignment> sundayList = Dates.getSundayAssignments(weeklyAssignments);
			request.setAttribute("sundayList", sundayList);
			request.setAttribute("dueSunday", sundayList.size());

			ArrayList<Assignment> mondayList = Dates.getMondayAssignments(weeklyAssignments);
			request.setAttribute("mondayList", mondayList);
			request.setAttribute("dueMonday", mondayList.size());

			ArrayList<Assignment> tuesdayList = Dates.getMondayAssignments(weeklyAssignments);
			request.setAttribute("tuesdayList", tuesdayList);
			request.setAttribute("dueTuesday", tuesdayList.size());

			ArrayList<Assignment> wednesdayList = Dates.getWednesdayAssignments(weeklyAssignments);
			request.setAttribute("wednesdayList", wednesdayList);
			request.setAttribute("dueWednesday", wednesdayList.size());

			ArrayList<Assignment> thursdayList = Dates.getThursdayAssignments(weeklyAssignments);
			request.setAttribute("thursdayList", thursdayList);
			request.setAttribute("dueThursday", thursdayList.size());

			ArrayList<Assignment> fridayList = Dates.getFridayAssignments(weeklyAssignments);
			request.setAttribute("fridayList", Dates.getFridayAssignments(weeklyAssignments));
			request.setAttribute("dueFriday", fridayList.size());

			ArrayList<Assignment> saturdayList = Dates.getSaturdayAssignments(weeklyAssignments);
			request.setAttribute("saturdayList", saturdayList);
			request.setAttribute("dueSaturday", saturdayList.size());

			ArrayList<Course> courses = CourseDAO.findByUserID(user.getUserID());
			request.setAttribute("courses", courses);
		}

		setMessagesInModel(m);
		return "assignment/weekly-assignments";
	}

	@GetMapping("/expand")
	public String expand(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login to View An Assignment");
			return "login";
		} else {

			int assignmentID = Integer.parseInt(request.getParameter("id"));
			Assignment assignment = AssignmentDAO.findByAssignmentID(assignmentID);
			assignment.setPriority(Priority.getPriorityLevel(assignment));
			request.setAttribute("assignment", assignment);
			return "assignment/assignment-expand";
		}
	}

	@PostMapping("/edit-assignment")
	public String edit(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login to Edit An Assignment");
			return "login";
		} else {

			int assignmentID = Integer.parseInt(request.getParameter("assignmentID"));
			int courseID = Integer.parseInt(request.getParameter("courseID"));
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			Timestamp due = Timestamp.valueOf(request.getParameter("due").replace('T', ' ') + ":00.0");
			int difficulty = Integer.parseInt(request.getParameter("difficulty"));
			int timeRequired = Integer.parseInt(request.getParameter("timeRequired"));
			String courseName = request.getParameter("courseName");

			if (due.before(new Timestamp(System.currentTimeMillis() + 900000))) {
				addErrorMessage("Invalid Assignment Due Date: Has to Be In At Least 15 Minutes");
				setMessagesInModel(m);
				return "user-profile";
			}

			Assignment a = new Assignment(assignmentID, courseID, name, courseName, desc, due, difficulty, timeRequired,
					2, true, null);
			a.setPriority(Priority.getPriorityLevel(a));

			if (AssignmentDAO.update(a) == 1) {
				addSuccessMessage("Assignment Updated!");
			}
		}

		setMessagesInModel(m);
		return "redirect:/account";
	}

	@PostMapping("/create-assignment")
	public String create(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login to Create An Assignment");
			return "login";
		} else {

			int courseID = Integer.parseInt(request.getParameter("course"));
			String name = request.getParameter("name");
			String desc = request.getParameter("description");
			Timestamp due = Timestamp.valueOf(request.getParameter("due").replace('T', ' ') + ":00.0");
			int difficulty = Integer.parseInt(request.getParameter("difficulty"));
			int timeRequired = Integer.parseInt(request.getParameter("timeRequired"));

			String reminder = request.getParameter("reminder");
			int reminderTime = Integer.parseInt(request.getParameter("reminderTime"));

			if (due.before(new Timestamp(System.currentTimeMillis() + 900000))) {
				addErrorMessage("Invalid Assignment Due Date: Has to Be In At Least 15 Minutes");
				setMessagesInModel(m);
				return "redirect:/home";
			}

			Assignment a = new Assignment(courseID, name, desc, due, difficulty, timeRequired, 0);
			a.setPriority(Priority.getPriorityLevel(a));

			if (AssignmentDAO.insert(a) == 1) {
				Timestamp reminderTs = new Timestamp(a.getDue().getTime() - (reminderTime * 60 * 1000));
				int assignmentID = AssignmentDAO.findByCourseIDAndName(courseID, name).getAssignmentID();

				if (reminder != null && reminder.equals("yes")) {
					if (ReminderDAO.insert(new Reminder(assignmentID, Reminder.EMAIL, user.getEmail(),
							user.getPhoneNumber(), reminderTs)) == 1) {
						NotificationRunner.main(null);
						addSuccessMessage("Assignment Created!");
					} else {
						addErrorMessage("Reminder Error");
					}
				}
				addSuccessMessage("Assignment Created!");
			}
		}

		setMessagesInModel(m);
		return "redirect:/home";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView model = new ModelAndView("index");
		return model;
	}

}