package pet.project.Messenger.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import pet.project.Messenger.dto.user.UserLogInDto;
import pet.project.Messenger.dto.user.UserRegisterDto;
import pet.project.Messenger.security.RegistrationForm;
import pet.project.Messenger.servise.AuthService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("/login")
	public String showLoginForm() {
	    return "auth/login";
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new UserRegisterDto());
		return "auth/register";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") UserRegisterDto userRegisterDto,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "auth/register";
		}

		authService.register(userRegisterDto);
		return "redirect:/auth/login?registered";
	}

	@GetMapping("/verify")
	public String verifyEmail(@RequestParam String token) {
		if (authService.verifyUser(token)) {
			return "redirect:/auth/login?verified";
		}
		return "redirect:/auth/login?error";
	}
}