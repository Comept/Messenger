package pet.project.Messenger.servise;

import java.util.List;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.repository.ContactsRepository;

@Repository
public class ContactsService {

	private final ContactsRepository contactsRepository;

	public ContactsService(ContactsRepository contactsRepository) {
		super();
		this.contactsRepository = contactsRepository;
	}
	public List<Contacts> findAll(){
		return contactsRepository.findByUserId("ali1");
	}
}
