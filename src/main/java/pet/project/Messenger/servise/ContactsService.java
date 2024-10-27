package pet.project.Messenger.servise;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ContactsRepository;
import pet.project.Messenger.repository.UserRepository;

@Repository
public class ContactsService {

	private final ContactsRepository contactsRepository;
	private final UserRepository userRepository;

	public ContactsService(ContactsRepository contactsRepository, UserRepository userRepository) {
		super();
		this.contactsRepository = contactsRepository;
		this.userRepository = userRepository;
	}
	public List<ContactDto> findUserContacts(UUID user_id){
		
		return contactsRepository.findByUser1(user_id);
	}
	
	public void addContact(UUID userId, UUID contactId) {
		contactsRepository.save(new Contacts(userId, contactId, new Date()));
	}
	
	public void deleteContact(UUID userId, UUID contactId) {
		contactsRepository.delete(new Contacts(userId, contactId,new Date()));
	}
}
