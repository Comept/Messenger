package pet.project.Messenger.dto.chat;

import lombok.Data;
import pet.project.Messenger.model.ChatRole;
import java.time.LocalDateTime;

@Data
public class ChatMemberDto {
	private Long userId;
	private Long chatId;
	private Boolean isBanned;
	private ChatRole role;
	private LocalDateTime joinedAt;
}
