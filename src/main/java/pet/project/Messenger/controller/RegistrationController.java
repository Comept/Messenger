package pet.project.Messenger.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pet.project.Messenger.repository.UserRepository;
import pet.project.Messenger.security.RegistrationForm;
@Controller 
@RequestMapping("/register")
public class RegistrationController {
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public RegistrationController(
		UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder; 
	}
	
	@GetMapping
	public String regForm() {
		return "registration.html"; 
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm registrationForm) {
		userRepository.save(registrationForm.toUser(passwordEncoder));
		return "redirect:/login"; 
	}
}