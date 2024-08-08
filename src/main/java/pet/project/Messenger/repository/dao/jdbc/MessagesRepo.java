package pet.project.Messenger.repository.dao.jdbc;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.dao.MessagesDao;

@Repository
public class MessagesRepo {
	
	private final MessagesDao messagesDao;

	public MessagesRepo(MessagesDao messagesDao) {
		super();
		this.messagesDao = messagesDao;
	}
	
}
