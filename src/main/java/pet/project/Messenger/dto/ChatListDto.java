package pet.project.Messenger.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ChatListDto {
	private String chatName;
	private MessageDto lastMessage;
	
	public ChatListDto(String chatName, UUID chatId, String username, UUID senderId, 
			String messageText, Date sentAt) {
		super();
		this.chatName = chatName;
		this.lastMessage = new MessageDto(chatId, username, senderId, messageText, sentAt);
	}
	
}
