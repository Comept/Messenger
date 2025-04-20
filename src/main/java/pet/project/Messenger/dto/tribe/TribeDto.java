package pet.project.Messenger.dto.tribe;

import lombok.Data;

@Data
public class TribeDto {
	private Long id;
	private String name;
	private String iconUrl;
	private Long mentorId;
	private Integer points;
}
