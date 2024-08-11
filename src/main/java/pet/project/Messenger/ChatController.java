package pet.project.Messenger;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pet.project.Messenger.model.Chats;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.servise.ContactsService;
import pet.project.Messenger.servise.UserService;

@Slf4j
@RequestMapping("/chats")
@Controller
public class ChatController {
	

	private final UserService userService;
	private final ContactsService contactsService;
	
	public ChatController(UserService userService, ContactsService contactsService) {
		super();
		this.userService = userService;
		this.contactsService = contactsService;
	}
	@GetMapping 
	public String chatPage(Model model) {
		List<Chats> chats = Arrays.asList(
				new Chats(1, "чат 1"),
				new Chats(2, "чат 2"),
				new Chats(3, "чат 3"),
				new Chats(4, "чат 4"),
				new Chats(5, "чат 5"),
				new Chats(6, "чат 3456")
				);
		//System.out.println(contactsService.findAll().toString());
		model.addAttribute("chats", chats);
		return "messenger.html"; 
	}
	
	@GetMapping("/createNew")
	public String creatingChatPage(Model model, Authentication authentication) {
		System.out.println(contactsService.findAll().toString());
		
		return "createNewChat.html";
	}
	
	
	
	
}
