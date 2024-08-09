package pet.project.Messenger;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.project.Messenger.repository.dao.UserRepo;
import pet.project.Messenger.security.RegistrationForm;

@Controller 
@RequestMapping("/loginn")
public class LoginController {
	
	private UserRepo userRepo;
	
	private PasswordEncoder passwordEncoder;
	
	public LoginController(
		UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder; 
	}
	
	@GetMapping
	public String registerForm() {
		return "loginn"; 
	}
	
	@PostMapping
	public String processRegistration(RegistrationForm form) {
		userRepo.save(form.toUser(passwordEncoder));
		return "redirect:/loginn"; 
	}

}
