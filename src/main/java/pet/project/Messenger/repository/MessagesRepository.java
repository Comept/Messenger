package pet.project.Messenger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pet.project.Messenger.dto.MessageDto;
import pet.project.Messenger.model.Message;

public interface MessagesRepository extends JpaRepository<Message,UUID>{
	public List<Message> findByChatId(UUID chatId);
	public List<Message> findByChatId(UUID chatId, PageRequest page);
	@Query("SELECT new pet.project.Messenger.dto.MessageDto(m.id, u.username, m.senderId, "
			+ "m.messageText, m.sentAt) "
			+ "FROM Message m "
			+ "JOIN User u ON u.id = m.senderId "
			+ "WHERE m.chatId = :chatId")
	public List<MessageDto> findListMessagesByChatId(UUID chatId);
}
