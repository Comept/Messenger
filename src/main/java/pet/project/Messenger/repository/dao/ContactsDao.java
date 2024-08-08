package pet.project.Messenger.repository.dao;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.entity.Contacts;

public interface ContactsDao extends CrudRepository<Contacts,Integer>{

}
