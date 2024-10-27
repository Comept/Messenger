package pet.project.Messenger.model.PrimeryKeyses;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.project.Messenger.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsPK implements Serializable{

	private static final long serialVersionUID = 7176995156043847749L;
	
	private UUID userId1;
	private UUID userId2;
}