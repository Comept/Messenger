package pet.project.Messenger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pet.project.Messenger.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	@Query("SELECT p FROM Profile p JOIN FETCH p.user WHERE p.id = :id")
	Optional<Profile> findByIdWithUser(@Param("id") Long id);
}
