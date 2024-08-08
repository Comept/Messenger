package pet.project.Messenger.repository.dao;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.entity.Messages;

public interface MessagesDao extends CrudRepository<Messages,Integer>{

}
