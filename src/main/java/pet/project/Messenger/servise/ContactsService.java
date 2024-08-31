package pet.project.Messenger.servise;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.dto.ContactDto;
import pet.project.Messenger.model.Contacts;
import pet.project.Messenger.model.User;
import pet.project.Messenger.repository.ContactsRepository;
import pet.project.Messenger.repository.UserRepository;
import pet.project.Messenger.model.PrimeryKeyses.ContactsPK;

@Repository
public class ContactsService {

	private final ContactsRepository contactsRepository;
	private final UserRepository userRepository;

	public ContactsService(ContactsRepository contactsRepository, UserRepository userRepository) {
		super();
		this.contactsRepository = contactsRepository;
		this.userRepository = userRepository;
	}
	public List<ContactDto> findUserContacts(long user_id){
		
		List<Contacts> contacts = contactsRepository.findByUserId1OrUserId2(user_id,user_id);
		
		List <Long> usersId =  contacts.stream()
				.map(contact -> {if(contact.getUserId1() == user_id) return contact.getUserId2();
				else return contact.getUserId1(); } ).toList();
		
		List<User> contactsUser = userRepository.findByIdIsIn(usersId);
		
		List<ContactDto> contactsDto = contactsUser.stream()
				.map(user -> new ContactDto(user.getUserId(), user.getUsername())).toList();
		
		return contactsDto;
	}
	
	public void addContact(long userId, long contactId) {
		contactsRepository.save(new Contacts(userId, contactId, new Date()));
	}
	
	public void deleteContact(long userId, long contactId) {
		contactsRepository.delete(new Contacts(userId, contactId,new Date()));
	}
}
