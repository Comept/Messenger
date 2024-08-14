package pet.project.Messenger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

public interface ContactsRepository extends CrudRepository<Contacts, ContactsPK>{
	List<Contacts> findByUserId1OrUserId2(long userid1, long userid2);
}
