package pet.project.Messenger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

public interface ContactsRepository extends JpaRepository<Contacts, ContactsPK>{
	List<Contacts> findByUserId1OrUserId2(UUID user_id, UUID user_id2);
	@Query("SELECT new pet.project.Messenger.dto.ContactDto(u.id, u.username) "
			+ "FROM Contacts c "
			+ "LEFT JOIN User u ON u.id = c.userId2 "
			+ "WHERE c.userId1 = :user")
	List<ContactDto> findByUser1(UUID user);
}
