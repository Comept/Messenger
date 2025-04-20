package pet.project.Messenger.dto.profile;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileCreateDto {
	private Long userId;
	private String firstName;
	private String secondName;
	private String avatarUrl;
	private String bio;
	private LocalDate birthDate;
}
