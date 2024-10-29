package pet.project.Messenger.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.project.Messenger.model.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
	
	private UUID id;
	private String username;
	private UUID senderId;
    private String messageText;
    private Date sentAt;   
    
	public MessageDto(Message message) {
		this.id = message.getId();
		this.username = "Unknown Username";
		this.senderId = message.getSenderId();
		this.messageText = message.getMessageText();
		this.sentAt = message.getSentAt();
	}
}
