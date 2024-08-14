package pet.project.Messenger.servise;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.ChatParticipantsRepository;

@Repository
public class ChatParticipantsService {

	private final ChatParticipantsRepository chatParticipantsRepository;

	public ChatParticipantsService(ChatParticipantsRepository chatParticipantsRepository) {
		super();
		this.chatParticipantsRepository = chatParticipantsRepository;
	}

	public boolean isUserMemberOfChat(long userId, long chatId) throws AccessDeniedException{
		if (chatParticipantsRepository.findByChatIdAndUserId(userId, chatId) == null)
			throw new AccessDeniedException("У пользователья " + userId + " нет прав доступа к чату " + chatId);
		else return true;
	}
	
}
