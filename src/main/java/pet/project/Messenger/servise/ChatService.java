package pet.project.Messenger.servise;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.ChatDto;
import pet.project.Messenger.dto.ChatListDto;
import pet.project.Messenger.dto.CreatChatDto;
import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.Chats;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ChatParticipantsRepository;
import pet.project.Messenger.repository.ChatsRepository;
import pet.project.Messenger.repository.MessagesRepository;

@Repository
public class ChatService {

	private final ChatsRepository chatsRepository;
	private final ChatParticipantsRepository chatParticipantsRepository;
	private final MessagesRepository messagesRepository;
	public ChatService(ChatsRepository chatsRepository, ChatParticipantsRepository chatParticipantsRepository, MessagesRepository messagesRepository) {
		super();
		this.chatsRepository = chatsRepository;
		this.chatParticipantsRepository = chatParticipantsRepository;
		this.messagesRepository = messagesRepository;
	}

	public void createChat(CreatChatDto creatChatDto) {
		Chats chat = new Chats();
		chat.setChatName(creatChatDto.getChatName());
		chat.setGroup(creatChatDto.getContacts().size() > 1);
		chatsRepository.save(chat);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		
		chatParticipantsRepository.save(new ChatParticipants(UUID.randomUUID(), chat.getId(), 
				user.getId(), "creater", new Date()));
		for (UUID userId : creatChatDto.getContacts()) {
			chatParticipantsRepository.save(new ChatParticipants(UUID.randomUUID(), chat.getId(), userId, "members", new Date()));
		}
	}
	public List<ChatListDto> getUserChats(UUID uuid) {
		return chatsRepository.findChatListByUserId(uuid);
	}
	
	public String getChatNameByChatId(UUID chatId) {
		return chatsRepository.findById(chatId).get().getChatName();
	}
}
