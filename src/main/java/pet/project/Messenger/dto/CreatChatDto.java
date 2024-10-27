package pet.project.Messenger.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatChatDto {
	private String chatName;
	private List<UUID> contacts;
	
	
}
