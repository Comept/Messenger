package pet.project.Messenger.dto.tribe;

import lombok.Data;

@Data
public class TribeMemberDto {
	private Long userId;
	private Long tribeId;
	private Integer points;
}
