package pet.project.Messenger.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.context.request.async.DeferredResult;

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
    private final Map<UUID,List<DeferredResult<Message>>> clients = new HashMap<>();

	@GetMapping("{id}/messages/all")
	public List<MessageDto> getAllMessages(@PathVariable("id") UUID chatId){
		
		return messageService.getMessagesByChatId(chatId);
	}
	@GetMapping("{id}/messages")
	public DeferredResult<Message> getChatMessage(@PathVariable("id") UUID chatId){
		DeferredResult<Message> deferredResult = new DeferredResult<>();
		if(!clients.containsKey(chatId)) clients.put(chatId,new ArrayList());
		clients.get(chatId).add(deferredResult);
		return deferredResult;
	}
	
	@PostMapping(path = "{id}/messages")
	public void saveMessage(@PathVariable("id") UUID chatId,
            @RequestBody String text,
            @AuthenticationPrincipal User user){
		Message message = messageService.saveMessage( chatId, user.getId(), text);
		for(DeferredResult<Message> client: clients.get(chatId)) {
			client.setResult(message);
		}
	}
}
