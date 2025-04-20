package pet.project.Messenger.dto.chat;

import lombok.Data;

@Data
public class ChatUpdateDto {
	private String name;
	private String iconUrl;
	private Boolean isActive;
}
