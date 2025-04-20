package pet.project.Messenger.dto.chat;

import lombok.Data;
import pet.project.Messenger.model.ChatRole;

@Data
public class ChatMemberCreateDto {
	private Long userId;
	private Long chatId;
	private ChatRole role;
}
