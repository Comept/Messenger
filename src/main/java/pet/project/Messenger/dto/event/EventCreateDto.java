package pet.project.Messenger.dto.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventCreateDto {
	private String name;
	private Long creatorId;
	private LocalDateTime startTime;
	private String location;
}
