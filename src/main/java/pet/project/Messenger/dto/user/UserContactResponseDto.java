package pet.project.Messenger.dto.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserContactResponseDto {
	private Long id;
	private UserDto contactUser;
	private LocalDateTime createdAt;
}
