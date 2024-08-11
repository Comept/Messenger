package pet.project.Messenger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

public interface ContactsRepository extends CrudRepository<Contacts, ContactsPK>{
	@Query("SELECT user_id, contact_id, created_at FROM contacts WHERE user_id = (select user_id from users where username = ':username')")
	public List<Contacts> findByUserId(String username);
}
