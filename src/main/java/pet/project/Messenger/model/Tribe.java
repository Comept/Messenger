package pet.project.Messenger.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tribes")
public class Tribe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "icon_url", length = 255)
	private String iconUrl;

	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private User mentor;

	private Integer points;

	@OneToMany(mappedBy = "tribe")
	private Set<TribeMember> members = new HashSet<>();
}