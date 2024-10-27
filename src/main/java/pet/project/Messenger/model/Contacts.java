package pet.project.Messenger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ContactsPK.class)
public class Contacts implements Serializable{
	private static final long serialVersionUID = -7445071266119644301L;
	@Id
	@Column(name="user1_id")
	private UUID userId1;
	@Id
	@Column(name="user2_id")
	private UUID userId2;
    private Date createdAt = new Date();
	
}