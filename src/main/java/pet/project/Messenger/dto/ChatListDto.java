package pet.project.Messenger.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ChatListDto {
	private String chatName;
	private MessageDto lastMessage;
	
	public ChatListDto(String chatName, String username, long senderId, 
			String messageText, Date sentAt) {
		super();
		this.chatName = chatName;
		this.lastMessage = new MessageDto(username, senderId, messageText, sentAt);
	}
	
}
