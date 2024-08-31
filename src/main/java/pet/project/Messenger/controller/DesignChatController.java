package pet.project.Messenger.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
import pet.project.Messenger.dto.ChatDto;
import pet.project.Messenger.dto.ChatParticipantsDto;
import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.dto.CreatChatDto;
import pet.project.Messenger.dto.MessageDto;
import pet.project.Messenger.model.Chats;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.servise.ChatParticipantsService;
import pet.project.Messenger.servise.ChatService;
import pet.project.Messenger.servise.ContactsService;
import pet.project.Messenger.servise.MessagesService;
import pet.project.Messenger.servise.UserService;

@Slf4j
@RequestMapping("/chats")
@Controller
public class DesignChatController {
	
	private final ContactsService contactsService;
	private final ChatService chatService;
	private final ChatParticipantsService chatParticipantsService;
	private final MessagesService messagesService;
	private final UserService userService;
	public DesignChatController(ContactsService contactsService, ChatService chatService, 
			ChatParticipantsService chatParticipantsService, MessagesService messagesService, UserService userService) {
		super();
		this.contactsService = contactsService;
		this.chatService = chatService;
		this.chatParticipantsService = chatParticipantsService;
		this.messagesService = messagesService;
		this.userService = userService;
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
			ChatDto chatDto = new ChatDto();
			
			//надо  впихнуть куда-нибудь
			//------------------------------
			List<ChatParticipantsDto> chatParticipants = 
					chatParticipantsService.getChatMembers(chatId).stream().map(participant -> new ChatParticipantsDto(participant)).toList();	
			HashMap<Long, String> usernames = userService.getUsernamesOfUsersById(chatParticipants.stream().map(participant -> participant.getUserId()).toList());
			Iterator<ChatParticipantsDto> participantIter = chatParticipants.iterator();
			while(participantIter.hasNext()) {
				ChatParticipantsDto participant = participantIter.next();
				participant.setUsername(usernames.get(participant.getUserId()));
			}
			//-------------------------------
			
			chatDto.setMembers(chatParticipants);
			
			chatDto.setMessages(messagesService.getMessagesByChatId(chatId));
			
			chatDto.setChatName(chatService.getChatNameByChatId(chatId));

			model.addAttribute("userId", user.getUserId());
			model.addAttribute("chatId", chatId);
			model.addAttribute("chatDto", chatDto);
			model.addAttribute("messageDto", new MessageDto());
		}
		catch(Exception ex){
				System.out.println(ex);
		}
		return "chat.html"; 
	}
	@PostMapping("/{id}")
	public String saveMessage(Model model, @PathVariable("id") Long chatId, @AuthenticationPrincipal User user, @ModelAttribute("messageDto") MessageDto message) {
		try{
			chatParticipantsService.isUserMemberOfChat(user.getUserId(), chatId);
			messagesService.saveMessage( chatId, user.getUserId(), message.getMessage());
		}
		catch(Exception ex){
				System.out.println(ex);
		}
		return "redirect:/chats/" + chatId; 
	}
	
}
