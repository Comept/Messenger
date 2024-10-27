package pet.project.Messenger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import pet.project.Messenger.model.User;
import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.dto.UserDto;
import pet.project.Messenger.servise.ContactsService;
import pet.project.Messenger.servise.UserService;

@Slf4j
@RequestMapping("/contact")
@Controller
public class DesignContactController {
	
	private UserService userService;
	private ContactsService contactsService;
	
	public DesignContactController (UserService userService, ContactsService contactsService) {
		this.userService = userService;
		this.contactsService = contactsService;
	}
	@GetMapping("/contacts")
	public String showContactsPage(@AuthenticationPrincipal User user, @RequestParam(value = "search", required = false) String search, Model model) {
		if(search == null) search = "";
		List<UserDto> unknownContacts = userService.getUsersWithUsernameLike(search+"%");
		List<ContactDto> knownContacts = contactsService.findUserContacts(user.getId());
	    model.addAttribute("users", unknownContacts);
	    model.addAttribute("knownContacts", knownContacts);
	    model.addAttribute("search", search);

	    return "contacts"; 
	    }
	@PostMapping("/addContact")
	public String addContact(@AuthenticationPrincipal User user, @RequestParam(value = "search", required = false) String search, @ModelAttribute("contactId") User newContact, Model model) {
		contactsService.addContact(user.getId(), newContact.getId());
		return "redirect:/contact/contacts";
	}
	@PostMapping("/removeContact")
	public String removeContact(@AuthenticationPrincipal User user, @RequestParam(value = "search", required = false) String search, @ModelAttribute("contactId") User removedContact, Model model) {
		System.out.print(removedContact);
		contactsService.deleteContact(user.getId(), removedContact.getId());
		return "redirect:/contact/contacts";
	}
}
