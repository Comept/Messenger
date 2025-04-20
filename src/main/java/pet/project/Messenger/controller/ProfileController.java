package pet.project.Messenger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pet.project.Messenger.model.Profile;
import pet.project.Messenger.repository.ProfileRepository;
import pet.project.Messenger.servise.ProfileService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

	private final ProfileService profileService;


	@GetMapping("/{id}")
	public String viewProfile(@PathVariable Long id, Model model) {
	    Profile profile = profileService.findUserProfile(id);
	    model.addAttribute("profile", profile);
	    return "profile/view";
	}
}