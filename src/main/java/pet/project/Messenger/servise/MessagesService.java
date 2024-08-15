package pet.project.Messenger.servise;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.Messages;
import pet.project.Messenger.repository.MessagesRepository;

@Repository
public class MessagesService {
	
	private final MessagesRepository messagesRepository;

	public MessagesService(MessagesRepository messagesRepository) {
		super();
		this.messagesRepository = messagesRepository;
	}
	
	public List<Messages> getMessagesByChatId(long chatId) {
		return messagesRepository.findByChatId(chatId).stream().toList();
	}
	
	public void saveMessage(long chatId, long senderId, String messageText) {
		messagesRepository.save(new Messages(chatId, senderId, messageText, new Date()));
	}
}