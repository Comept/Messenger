package pet.project.Messenger.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
	private String username;
	private long senderId;
    private String messageText;
    private Date sentAt;
    
}
