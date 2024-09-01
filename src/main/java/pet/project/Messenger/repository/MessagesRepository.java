package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Messages;

public interface MessagesRepository extends CrudRepository<Messages,Long>{
	public List<Messages> findByChatId(long chatId);
	public List<Messages> findByChatId(long chatId, PageRequest page);
}
