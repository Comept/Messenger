package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Chats;

public interface ChatsRepository extends CrudRepository<Chats,Long>{
	public List<Chats> findByIdIn(List<Long> chatsId);
}
