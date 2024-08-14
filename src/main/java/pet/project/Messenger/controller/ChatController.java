package pet.project.Messenger.controller;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.dto.CreatChatDto;
import pet.project.Messenger.model.Chats;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.servise.ChatParticipantsService;
import pet.project.Messenger.servise.ChatService;
import pet.project.Messenger.servise.ContactsService;
import pet.project.Messenger.servise.UserService;

@Slf4j
@RequestMapping("/chats")
@Controller
public class ChatController {
	
	private final ContactsService contactsService;
	private final ChatService chatService;
	private final ChatParticipantsService chatParticipantsService;
	public ChatController(ContactsService contactsService, ChatService chatService, 
			ChatParticipantsService chatParticipantsService) {
		super();
		this.contactsService = contactsService;
		this.chatService = chatService;
		this.chatParticipantsService = chatParticipantsService;
	}
	@GetMapping 
	public String viewMessengerPage(Model model,  @AuthenticationPrincipal User user) {
		
		//System.out.println(contactsService.findAll().toString());
		model.addAttribute("chats", chatService.getUserChats(user.getUserId()));
		return "messenger.html"; 
	}
	
	@GetMapping("/create-chat")
	public String creatingChatGetResponse(Model model, @AuthenticationPrincipal User user) {
		model.addAttribute("contacts", contactsService.findUserContacts(user.getUserId()));
		model.addAttribute("contactsForm", new CreatChatDto());
		return "createNewChat.html";
	}
	
	
	@PostMapping("/create-chat")
	public String creatChatPostResponse(Model model, @AuthenticationPrincipal User user, @ModelAttribute("contactsForm") CreatChatDto contactsForm) {
		System.out.println(contactsForm.getContacts().get(0));
		chatService.createChat(contactsForm);
		return "redirect:/chats";
	}
	
	@GetMapping("/{id}")
	public String viewChatPage(Model model, @PathVariable("id") Long chatId, @AuthenticationPrincipal User user) {
		try{
			chatParticipantsService.isUserMemberOfChat(user.getUserId(), chatId);
		}
		catch(Exception ex){
				System.out.println(ex);
		}
		return "messenger.html"; 
	}
	
}
