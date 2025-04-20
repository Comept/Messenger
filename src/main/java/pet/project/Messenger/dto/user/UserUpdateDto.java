package pet.project.Messenger.dto.user;

import lombok.Data;

@Data
public class UserUpdateDto {
	private String username;
	private String email;
	private Boolean isActive;
}
