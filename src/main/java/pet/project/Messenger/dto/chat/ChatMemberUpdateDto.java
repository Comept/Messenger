package pet.project.Messenger.dto.chat;

import lombok.Data;
import pet.project.Messenger.model.ChatRole;

@Data
public class ChatMemberUpdateDto {
	private Boolean isBanned;
	private ChatRole role;
}
