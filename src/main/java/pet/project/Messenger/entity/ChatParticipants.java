package pet.project.Messenger.entity;

import java.sql.Date;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("chatParticipants")
public class ChatParticipants {
	@Column("chat_id")
	private long chatId;
	@Column("user_id")
    private long userId;
    private String role;
    @Column("joined_at")
    private Date joinedAt;

    public ChatParticipants() {
    }

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
}