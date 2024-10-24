package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.Message;

public interface MessagesRepository extends CrudRepository<Message,Long>{
	public List<Message> findByChatId(long chatId);
	public List<Message> findByChatId(long chatId, PageRequest page);
}
