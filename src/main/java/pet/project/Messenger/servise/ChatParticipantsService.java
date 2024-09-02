package pet.project.Messenger.servise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.ChatParticipantsDto;
import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ChatParticipantsRepository;
import pet.project.Messenger.repository.UserRepository;

@Repository
public class ChatParticipantsService {

	private final ChatParticipantsRepository chatParticipantsRepository;
	private final UserRepository userRepository;

	public ChatParticipantsService(ChatParticipantsRepository chatParticipantsRepository, UserRepository userRepository) {
		super();
		this.chatParticipantsRepository = chatParticipantsRepository;
		this.userRepository = userRepository;
	}

	public boolean isUserMemberOfChat(long userId, long chatId) throws AccessDeniedException{
		if (chatParticipantsRepository.findByChatIdAndUserId(chatId, userId) == null)
			throw new AccessDeniedException("У пользователья " + userId + " нет прав доступа к чату " + chatId);
		else return true;
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
	
	public List<ChatParticipantsDto> getChatParticipants(long chatId){
		List<ChatParticipantsDto> chatParticipants = 
				chatParticipantsRepository.findByChatId(chatId).stream().map(participant -> new ChatParticipantsDto(participant)).toList();	
		HashMap<Long, String> usernames = new HashMap<Long, String> ();
		Iterator<User> iterUser = userRepository.findAllById(chatParticipants.stream().map(participant -> participant.getUserId()).toList()).iterator();
		while(iterUser.hasNext()) {
			User user = iterUser.next();
			usernames.put(user.getUserId(), user.getUsername());
		}
		Iterator<ChatParticipantsDto> participantIter = chatParticipants.iterator();
		while(participantIter.hasNext()) {
			ChatParticipantsDto participant = participantIter.next();
			participant.setUsername(usernames.get(participant.getUserId()));
		}
		return chatParticipants;
	}
}
