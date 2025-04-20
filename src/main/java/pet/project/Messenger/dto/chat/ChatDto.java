package pet.project.Messenger.dto.chat;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChatDto {
	private Long id;
	private String name;
	private String iconUrl;
	private Long creatorId;
	private LocalDateTime createdAt;
	private Boolean isActive;
	private LocalDateTime updatedAt;
	private Boolean isDeleted;
}
