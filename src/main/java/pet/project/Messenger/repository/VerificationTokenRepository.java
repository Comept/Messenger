package pet.project.Messenger.repository;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, String> {
}