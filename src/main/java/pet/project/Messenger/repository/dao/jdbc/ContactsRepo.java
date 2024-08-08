package pet.project.Messenger.repository.dao.jdbc;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.dao.ContactsDao;

@Repository
public class ContactsRepo {

	private final ContactsDao contactsDao;

	public ContactsRepo(ContactsDao contactsDao) {
		super();
		this.contactsDao = contactsDao;
	}
	
}
