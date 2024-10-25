package pet.project.Messenger.servise;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.MessageDto;
import pet.project.Messenger.model.Message;
import pet.project.Messenger.repository.MessagesRepository;

@Repository
public class MessagesService {
	
	private final MessagesRepository messagesRepository;

	public MessagesService(MessagesRepository messagesRepository) {
		super();
		this.messagesRepository = messagesRepository;
	}
	
	public List<MessageDto> getMessagesByChatId(long chatId) {
		return messagesRepository.findListMessagesByChatId(chatId);
	}
	
	public Message saveMessage(long chatId, long senderId, String messageText) {
		Message message = new Message(chatId, senderId, messageText, new Date());
		messagesRepository.save(message);
		return message;
	}
}