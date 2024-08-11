package pet.project.Messenger.servise;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.ChatParticipantsRepository;

@Repository
public class ChatParticipantsRepo {

	private final ChatParticipantsRepository chatParticipantsRepository;

	public ChatParticipantsRepo(ChatParticipantsRepository chatParticipantsRepository) {
		super();
		this.chatParticipantsRepository = chatParticipantsRepository;
	}
	
}
