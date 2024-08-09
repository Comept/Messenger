package pet.project.Messenger;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.project.Messenger.repository.dao.UserRepo;
import pet.project.Messenger.security.RegistrationForm;
@Controller 
@RequestMapping("/register")
public class RegistrationController {
	
	private UserRepo userRepo;
	
	private PasswordEncoder passwordEncoder;
	
	public RegistrationController(
		UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder; 
	}
	
	@GetMapping
	public String registerForm() {
		return "registration"; 
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/login"; 
	}
}