package pet.project.Messenger.dto.user;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserContactDto {
	private Long id;
	private Long userId;
	private Long contactUserId;
	private LocalDateTime createdAt;
}
