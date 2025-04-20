package pet.project.Messenger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pet.project.Messenger.exception.UserAlreadyExistsException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public String handleUserExists(UserAlreadyExistsException ex, Model model) {
		model.addAttribute("error", ex.getMessage());
		return "profile/0";
	}
}