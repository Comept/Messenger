package pet.project.Messenger.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tribe_members")
public class TribeMember {
	@EmbeddedId
	private TribeMemberId id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("tribeId")
	@JoinColumn(name = "tribe_id")
	private Tribe tribe;

	private Integer points;
}
