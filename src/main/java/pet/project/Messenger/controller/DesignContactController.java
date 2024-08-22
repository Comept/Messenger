package pet.project.Messenger.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pet.project.Messenger.model.User;

@Slf4j
@RequestMapping("/contact")
@Controller
public class DesignContactController {
		
	@GetMapping 
	public String viewMessengerPage(@AuthenticationPrincipal User user) {
		
		return "contacts.html"; 
	}
	
}
