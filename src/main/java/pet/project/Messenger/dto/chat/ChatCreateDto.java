package pet.project.Messenger.dto.chat;

import lombok.Data;

@Data
public class ChatCreateDto {
	private String name;
	private String iconUrl;
	private Long creatorId;
}
