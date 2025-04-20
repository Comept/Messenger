package pet.project.Messenger.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "chat_members")
public class ChatMember {
	@EmbeddedId
	private ChatMemberId id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("chatId")
	@JoinColumn(name = "chat_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Chat chat;

	@Column(name = "is_banned")
	private Boolean isBanned = false;

	@Enumerated(EnumType.STRING)
	private ChatRole role = ChatRole.MEMBER;

	@Column(name = "joined_at")
	private LocalDateTime joinedAt;

}
