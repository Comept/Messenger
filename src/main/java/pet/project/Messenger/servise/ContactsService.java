package pet.project.Messenger.servise;

import java.util.List;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ContactsRepository;

@Repository
public class ContactsService {

	private final ContactsRepository contactsRepository;

	public ContactsService(ContactsRepository contactsRepository) {
		super();
		this.contactsRepository = contactsRepository;
	}
	public void findUserContacts(long user_id){
		List<Contacts> c = contactsRepository.findByUserId1(user_id);
		//if(c==null) System.out.println("@3234");
//		return null;
	}
}
