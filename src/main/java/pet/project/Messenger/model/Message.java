package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message implements Serializable{
	
	private static final long serialVersionUID = -6374789486579840311L;
	
	@Id
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
	@Builder.Default
    private UUID id = UUID.randomUUID();
    private UUID chatId;
	private UUID senderId;
    private String messageText;
    private Date sentAt;
    
	public Message(UUID chatId, UUID senderId, String messageText) {
		super();
		this.chatId = chatId;
		this.senderId = senderId;
		this.messageText = messageText;
	}
	
}