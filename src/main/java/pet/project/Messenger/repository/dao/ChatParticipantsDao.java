package pet.project.Messenger.repository.dao;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.entity.ChatParticipants;

public interface ChatParticipantsDao extends CrudRepository<ChatParticipants,Integer>{

}
