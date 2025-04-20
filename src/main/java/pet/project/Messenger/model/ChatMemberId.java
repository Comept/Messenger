package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class ChatMemberId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long chatId;
}