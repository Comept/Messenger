package pet.project.Messenger.dto.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventUpdateDto {
	private String name;
	private LocalDateTime startTime;
	private String location;
}
