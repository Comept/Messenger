package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.project.Messenger.model.PrimeryKeyses.ChatPartricipantsPK;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatParticipants implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique=true, nullable = false)
	private long id;
	private long chatId;
    private long userId;
    private String role;
    private Date joinedAt;

    public ChatParticipants(long chatId, long userId, String role, Date joinedAt) {
        setChatId(chatId);
        setUserId(userId);
        setRole(role);
        setJoinedAt(joinedAt);
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
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

	@Override
	public String toString() {
		return "ChatParticipants [chatId=" + chatId + ", userId=" + userId + ", role=" + role + ", joinedAt=" + joinedAt
				+ "]";
	}
    
}