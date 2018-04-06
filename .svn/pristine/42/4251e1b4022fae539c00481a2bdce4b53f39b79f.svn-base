package edu.ben.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ben.DAOs.CourseDAO;
import edu.ben.models.Course;
import edu.ben.models.User;

@Controller
public class CourseController extends BaseController {

	public CourseController() {
		super();
	}

	@GetMapping("/view-courses")
	public String get(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {

			addWarningMessage("Login to View Courses");
			setMessagesInModel(m);
			return "login";

		} else {
			ArrayList<Course> courses = CourseDAO.findByUserID(user.getUserID());
			request.getSession().setAttribute("courses", courses);
			setMessagesInModel(m);
			return "view-courses";
		}
	}

	@PostMapping("/delete-course")
	public String delete(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {

			addWarningMessage("Login to Delete A Course");
			setMessagesInModel(m);
			return "login";

		} else {
			int courseID = Integer.parseInt(request.getParameter("courseID"));
			CourseDAO.deactivate(courseID);
			addSuccessMessage("Course Deleted");
			setMessagesInModel(m);
			return "home";
		}
	}

	@PostMapping("/edit-course")
	public String edit(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {

			addWarningMessage("Login to Edit A Course");
			setMessagesInModel(m);
			return "login";

		} else {
			int courseID = Integer.parseInt(request.getParameter("courseID"));
			String name = request.getParameter("name");
			String desc = request.getParameter("description");

			if (courseID > 0 && name != null && desc != null) {
				CourseDAO.update(new Course(courseID, name, desc));
				addSuccessMessage("Course Edited");
			} else {
				addErrorMessage("Invalid Course Input");
			}
			setMessagesInModel(m);
			return "home";
		}
	}

	@PostMapping("/create-course")
	public String create(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Course> courses = new ArrayList<Course>();

		if (user == null) {

			addWarningMessage("Login to Create A Course");
			return "login";

		} else {

			courses = CourseDAO.findByUserID(user.getUserID());

			String name = request.getParameter("name");
			String desc = request.getParameter("description");

			if (courses.contains(new Course(user.getUserID(), name, desc))) {
				addErrorMessage(name + " Already Exists As A Course");
				setMessagesInModel(m);
				return "redirect:/home";
			}

			CourseDAO.insert(new Course(user.getUserID(), name, desc));
			addSuccessMessage("Course Created!");
		}

		courses = CourseDAO.findByUserID(user.getUserID());
		request.getSession().setAttribute("courses", courses);
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
