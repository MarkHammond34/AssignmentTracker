package edu.ben.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public abstract class BaseController extends AbstractController {

	private ArrayList<String> errorMessages = new ArrayList<String>();
	private ArrayList<String> warningMessages = new ArrayList<String>();
	private ArrayList<String> successMessages = new ArrayList<String>();

	public void setMessagesInModel(Model model) {
		model.addAttribute("errorMessages", errorMessages);
		model.addAttribute("warningMessages", warningMessages);
		model.addAttribute("successMessages", successMessages);
	}

	public void addErrorMessage(String error) {
		errorMessages.add(error);

	}

	public void addSuccessMessage(String suc) {
		successMessages.add(suc);
	}

	public void addWarningMessage(String warning) {
		warningMessages.add(warning);
	}

	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}

	public ArrayList<String> getWarningMessages() {
		return warningMessages;
	}

	public ArrayList<String> getSuccessMessages() {
		return successMessages;
	}

	public void setErrorMessages(ArrayList<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public void setWarningMessages(ArrayList<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

	public void setSuccessMessages(ArrayList<String> successMessages) {
		this.successMessages = successMessages;
	}

	@Override
	protected abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception;
}