package pet.project.Messenger.servise;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.MessagesRepository;

@Repository
public class MessagesRepo {
	
	private final MessagesRepository messagesRepository;

	public MessagesRepo(MessagesRepository messagesRepository) {
		super();
		this.messagesRepository = messagesRepository;
	}
	
}
