package pet.project.Messenger;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.project.Messenger.repository.UserRepository;
import pet.project.Messenger.security.RegistrationForm;

@Controller 
@RequestMapping("/login")
public class LoginController {
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public LoginController(
		UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder; 
	}
	
	@GetMapping
	public String registerForm() {
		return "login.html"; 
	}

}
