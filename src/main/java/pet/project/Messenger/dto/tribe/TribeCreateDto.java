package pet.project.Messenger.dto.tribe;

import lombok.Data;

@Data
public class TribeCreateDto {
	private String name;
	private String iconUrl;
	private Long mentorId;
}
