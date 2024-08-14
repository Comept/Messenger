package pet.project.Messenger.servise;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.CreatChatDto;
import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.Chats;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ChatParticipantsRepository;
import pet.project.Messenger.repository.ChatsRepository;

@Repository
public class ChatService {

	private final ChatsRepository chatsRepository;
	private final ChatParticipantsRepository chatParticipantsRepository;
	public ChatService(ChatsRepository chatsRepository, ChatParticipantsRepository chatParticipantsRepository) {
		super();
		this.chatsRepository = chatsRepository;
		this.chatParticipantsRepository = chatParticipantsRepository;
	}

	public void createChat(CreatChatDto creatChatDto) {
		Chats chat = new Chats();
		chat.setChatName(creatChatDto.getChatName());
		chat.setIsGroup(creatChatDto.getContacts().size() > 1);
		chatsRepository.save(chat);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		
		chatParticipantsRepository.save(new ChatParticipants(chat.getId(), user.getUserId(), "creater", new Date()));
		for (long userId : creatChatDto.getContacts()) {
			chatParticipantsRepository.save(new ChatParticipants(chat.getId(), userId, "members", new Date()));
		}
	}
	public List<Chats> getUserChats(long userId) {
		List<ChatParticipants> userChats = chatParticipantsRepository.findChatIsByUserId(userId);
		return chatsRepository.findByIdIn(userChats.stream().map(r->r.getChatId()).toList());
	}
}
