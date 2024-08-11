package pet.project.Messenger.repository;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Messages;

public interface MessagesRepository extends CrudRepository<Messages,Integer>{

}
