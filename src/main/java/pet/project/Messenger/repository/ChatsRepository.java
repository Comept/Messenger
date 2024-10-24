package pet.project.Messenger.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pet.project.Messenger.dto.ChatListDto;
import pet.project.Messenger.model.Chats;

public interface ChatsRepository extends JpaRepository<Chats,Long>{
	 @Query("SELECT new pet.project.Messenger.dto.ChatListDto(c.chatName, c.id, "
	 		+ "u.username, COALESCE(m.senderId, 0), "+
	 		 "m.messageText, m.sentAt) "+
				"FROM (SELECT chatId as id "+
				"FROM ChatParticipants "+
				"WHERE userId = :userId) as cp "+
				"LEFT JOIN Chats c ON c.id = cp.id "+
				"LEFT JOIN Message m ON m.chatId = c.id "+
				"LEFT JOIN User u ON u.id = m.senderId "+
				"ORDER BY m.sentAt DESC "+
				"LIMIT 1")
	 public List<ChatListDto> findChatListByUserId(@Param("userId") Long userId);
}
