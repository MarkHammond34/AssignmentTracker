package edu.ben.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ben.DAOs.AssignmentDAO;
import edu.ben.DAOs.CourseDAO;
import edu.ben.DAOs.UserDAO;
import edu.ben.models.Assignment;
import edu.ben.models.Course;
import edu.ben.models.User;

@Controller
public class UserController extends BaseController {

	@Autowired
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserController() {
		super();
	}

	@PostMapping("/register")
	public String create(HttpServletRequest request, Model m) {

		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String passwordConfirm = (String) request.getParameter("password");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));

		if (!password.equals(passwordConfirm)) {
			addErrorMessage("Passwords Do Not Match");
			setMessagesInModel(m);
			return "register";
		}

		User user = UserDAO.findByEmail(email);

		if (user != null && !user.isActive()) {
			addErrorMessage("Locked Account Exists Under " + email);
			setMessagesInModel(m);
			return "register";
		}

		if (user != null) {
			addErrorMessage("Account Already Exists Under " + email);
			setMessagesInModel(m);
			return "register";
		}

		password = passwordEncoder.encode(password);

		user = new User(firstName, lastName, email, password, phoneNumber);

		if (UserDAO.insert(user) == 1) {
			addSuccessMessage("User Created");
		}

		request.getSession().setAttribute("user", UserDAO.findByEmail(email));

		setMessagesInModel(m);
		return "course/course-setup";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, Model m) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = UserDAO.findByEmail(email);

		if (user == null) {
			addErrorMessage("Invalid Email");
			setMessagesInModel(m);
			return "login";
		}

		if (!passwordEncoder.matches(password, user.getPassword())) {
			addErrorMessage("Invalid Password");
			setMessagesInModel(m);
			return "login";
		}

		ArrayList<Assignment> dailyAssignments = AssignmentDAO.getDailyAssignments(user.getUserID());
		ArrayList<Course> courses = CourseDAO.findByUserID(user.getUserID());
		request.setAttribute("assignments", dailyAssignments);
		request.setAttribute("courses", courses);

		request.getSession().setAttribute("user", user);
		setMessagesInModel(m);
		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model m) {

		request.getSession().removeAttribute("user");
		addSuccessMessage("You've Logged Out");
		setMessagesInModel(m);
		return "redirect:/home";
	}

	@GetMapping("/account")
	public String account(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		if (user == null) {
			addWarningMessage("Login To View Account");
			setMessagesInModel(m);
			return "login";
		}

		ArrayList<Assignment> weeklyAssignments = AssignmentDAO.getWeeklyAssignments(user.getUserID());
		request.setAttribute("weeklyAssignments", weeklyAssignments);

		setMessagesInModel(m);
		return "user-profile";
	}

	@PostMapping("/edit-user")
	public String editUser(HttpServletRequest request, Model m) {

		User user = (User) request.getSession().getAttribute("user");

		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String email = (String) request.getParameter("email");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));

		if (user == null) {
			addWarningMessage("Login To Edit Account Information");
			setMessagesInModel(m);
			return "login";
		} else {
			if (UserDAO.update(new User(user.getUserID(), firstName, lastName, email, user.getPassword(), phoneNumber,
					null, true)) == 1) {
				addSuccessMessage("Information Updated");
				request.getSession().setAttribute("user", UserDAO.findByEmail(email));
			}
		}

		setMessagesInModel(m);
		return "redirect:/account";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView model = new ModelAndView("index");
		return model;
	}

}