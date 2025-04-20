package pet.project.Messenger.dto.user;

import lombok.Data;

@Data
public class UserCreateDto {
	private String username;
	private String email;
	private String password;
}
