package pet.project.Messenger.web.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pet.project.Messenger.dto.ChatDto;
import pet.project.Messenger.servise.ChatParticipantsService;
import pet.project.Messenger.servise.ChatService;
import pet.project.Messenger.servise.MessagesService;

@RestController 
@RequestMapping(path="/api/chats/{id}",produces="application/json") 
public class ChatController {
	
	private final ChatService chatService;
	private final ChatParticipantsService chatParticipantsService;
	private final MessagesService messagesService;
		
	public ChatController(ChatService chatService, ChatParticipantsService chatParticipantsService,
			MessagesService messagesService) {
		super();
		this.chatService = chatService;
		this.chatParticipantsService = chatParticipantsService;
		this.messagesService = messagesService;
	}




	@GetMapping(params="recent")
	public ChatDto  getChat(@PathVariable("id") Long chatId,@RequestParam("recent") int recent){
		
		PageRequest page = PageRequest.of(
				recent, 12, Sort.by("sentAt").descending());
		
		
		ChatDto chatDto = new ChatDto();
		
		chatDto.setMembers(chatParticipantsService.getChatParticipants(chatId));
		
		chatDto.setMessages(messagesService.getMessagesByChatId(chatId, page));
		
		chatDto.setChatName(chatService.getChatNameByChatId(chatId));

		chatDto.setUserId(0);//добавить авторизацию для веб сервисов 

		return chatDto;
		
	}

}
