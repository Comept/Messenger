package pet.project.Messenger.servise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pet.project.Messenger.dto.ChatParticipantsDto;
import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ChatParticipantsRepository;
import pet.project.Messenger.repository.UserRepository;

@RequiredArgsConstructor
@Repository
public class ChatParticipantsService {

	private final ChatParticipantsRepository chatParticipantsRepository;

	public boolean isUserMemberOfChat(UUID uuid, UUID chatId) throws AccessDeniedException{
		if (chatParticipantsRepository.findByChatIdAndUserId(chatId, uuid) == null)
			throw new AccessDeniedException("У пользователья " + uuid + " нет прав доступа к чату " + chatId);
		else return true;
	}
}
