package edu.ben.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ben.DAOs.AssignmentDAO;
import edu.ben.DAOs.CourseDAO;
import edu.ben.models.Assignment;
import edu.ben.models.Course;
import edu.ben.models.User;
import edu.ben.util.NotificationRunner;
import edu.ben.util.Priority;

@Controller
public class HomeController extends BaseController {

	public HomeController() {
		super();
	}

	@GetMapping("/index")
	public String homeGet(HttpServletRequest request, Model m) {
		return homeGet2(request, m);
	}

	@GetMapping("/home")
	public String homeGet3(HttpServletRequest request, Model m) {
		return homeGet2(request, m);
	}

	@GetMapping("/")
	public String homeGet2(HttpServletRequest request, Model m) {

		NotificationRunner.main(null);

		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			ArrayList<Assignment> dailyAssignments = Priority
					.sortByPriority(AssignmentDAO.getDailyAssignments(user.getUserID()));
			ArrayList<Course> courses = CourseDAO.findByUserID(user.getUserID());
			request.setAttribute("assignments", dailyAssignments);
			request.setAttribute("courses", courses);
			setMessagesInModel(m);
			return "index";
		}

		setMessagesInModel(m);
		return "welcome";
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}

	@GetMapping("/register")
	public String register(HttpServletRequest request) {
		return "register";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView model = new ModelAndView("index");
		return model;
	}

}
