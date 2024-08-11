package pet.project.Messenger.repository;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.ChatParticipants;

public interface ChatParticipantsRepository extends CrudRepository<ChatParticipants,Integer>{

}
