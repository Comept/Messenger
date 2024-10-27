package pet.project.Messenger.model;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chats {
	@Id
	@Basic(optional = false)
	@Column(unique=true, nullable = false)
	@Builder.Default
	private UUID id = UUID.randomUUID();
	private String chatName;
	private boolean isGroup;
}