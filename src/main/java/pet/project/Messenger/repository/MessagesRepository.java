package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.dto.MessageDto;
import pet.project.Messenger.model.Message;

public interface MessagesRepository extends CrudRepository<Message,Long>{
	public List<Message> findByChatId(long chatId);
	public List<Message> findByChatId(long chatId, PageRequest page);
	@Query("SELECT new pet.project.Messenger.dto.MessageDto(m.id, u.username, m.senderId, "
			+ "m.messageText, m.sentAt) "
			+ "FROM Message m "
			+ "JOIN User u ON u.id = m.senderId "
			+ "WHERE m.chatId = :chatId")
	public List<MessageDto> findListMessagesByChatId(long chatId);
}
