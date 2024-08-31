package pet.project.Messenger.servise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ChatParticipantsRepository;

@Repository
public class ChatParticipantsService {

	private final ChatParticipantsRepository chatParticipantsRepository;

	public ChatParticipantsService(ChatParticipantsRepository chatParticipantsRepository) {
		super();
		this.chatParticipantsRepository = chatParticipantsRepository;
	}

	public boolean isUserMemberOfChat(long userId, long chatId) throws AccessDeniedException{
		if (chatParticipantsRepository.findByChatIdAndUserId(chatId, userId) == null)
			throw new AccessDeniedException("У пользователья " + userId + " нет прав доступа к чату " + chatId);
		else return true;
	}
	
	public List<ChatParticipants> getChatMembers(long chatId){
		return chatParticipantsRepository.findByChatId(chatId);
	}
	
	public HashMap<Long, String> getMembersRole(long chatId, List<Long> userIds){
		HashMap<Long, String> result = new HashMap<Long, String> ();
		Iterator<ChatParticipants> iterUser =  chatParticipantsRepository.findByChatIdAndUserIdIn(chatId, userIds).iterator();
		while(iterUser.hasNext()) {
			ChatParticipants user = iterUser.next();
			result.put(user.getUserId(), user.getRole());
		}
		return result;
	}
}
