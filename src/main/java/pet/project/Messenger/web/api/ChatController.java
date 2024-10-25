package pet.project.Messenger.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pet.project.Messenger.dto.MessageDto;
import pet.project.Messenger.model.Message;
import pet.project.Messenger.model.User;
import pet.project.Messenger.servise.MessagesService;

@RestController
@RequestMapping(path="/api/chats")
@RequiredArgsConstructor
public class ChatController {
	private final MessagesService messageService;
	@GetMapping("{id}/messages")
	public List<MessageDto> getChatMessages(@PathVariable("id") Long chatId){
		return messageService.getMessagesByChatId(chatId);
	}
	
	@PostMapping(path = "{id}/messagess")
	public Message saveMessage(@PathVariable("id") Long chatId,
            @RequestBody String text,
            @AuthenticationPrincipal User user){
		System.out.println("sadasdsadasdsadsadsad");
		return messageService.saveMessage( chatId, user.getUserId(), text);
	}
}
