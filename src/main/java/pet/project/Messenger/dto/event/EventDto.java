package pet.project.Messenger.dto.event;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDto {
	private Long id;
	private String name;
	private Long creatorId;
	private LocalDateTime startTime;
	private String location;
}
