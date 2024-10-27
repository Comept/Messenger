package pet.project.Messenger.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.project.Messenger.model.ChatParticipants;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatParticipantsDto{

	private String username;
    private UUID userId;
    private String role;
    private Date joinedAt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ChatParticipantsDto(UUID userId, String role, Date joinedAt) {
		super();
		this.userId = userId;
		this.role = role;
		this.joinedAt = joinedAt;
	}
	public ChatParticipantsDto(ChatParticipants chatParticipants) {
		super();
		this.userId = chatParticipants.getUserId();
		this.role = chatParticipants.getRole();
		this.joinedAt = chatParticipants.getJoinedAt();
	}
	
}
