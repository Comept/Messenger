package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class TribeMemberId implements Serializable {
	private Long userId;
	private Long tribeId;
}