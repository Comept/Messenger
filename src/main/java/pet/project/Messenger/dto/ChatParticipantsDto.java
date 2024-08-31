package pet.project.Messenger.dto;

import java.util.Date;

import jakarta.persistence.Id;
import pet.project.Messenger.model.ChatParticipants;

public class ChatParticipantsDto{

	private String username;
    private long userId;
    private String role;
    private Date joinedAt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(Date joinedAt) {
		this.joinedAt = joinedAt;
	}
	public ChatParticipantsDto(long userId, String role, Date joinedAt) {
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
