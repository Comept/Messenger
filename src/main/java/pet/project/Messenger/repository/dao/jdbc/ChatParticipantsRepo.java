package pet.project.Messenger.repository.dao.jdbc;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.dao.ChatParticipantsDao;

@Repository
public class ChatParticipantsRepo {

	private final ChatParticipantsDao chatParticipantsDao;

	public ChatParticipantsRepo(ChatParticipantsDao chatParticipantsDao) {
		super();
		this.chatParticipantsDao = chatParticipantsDao;
	}
	
}
