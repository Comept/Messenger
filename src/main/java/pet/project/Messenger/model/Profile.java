package pet.project.Messenger.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "profiles")
public class Profile {
	@Id
	private Long userId;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_ref")
	private User user;

	@Column(name = "first_name", length = 100)
	private String firstName;

	@Column(name = "second_name", length = 100)
	private String secondName;

	@Column(name = "avatar_url", length = 255)
	private String avatarUrl;

	private String bio;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	private Integer coins;

	public boolean getIsDeleted() {
		return user != null && user.getIsDeleted();
	}
}
