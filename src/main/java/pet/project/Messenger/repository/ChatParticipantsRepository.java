package pet.project.Messenger.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.ChatParticipants;

public interface ChatParticipantsRepository extends CrudRepository<ChatParticipants,UUID>{
	public ChatParticipants findByChatIdAndUserId(UUID chatId, UUID uuid);
	public List<ChatParticipants> findChatIsByUserId(UUID userId);
	public List<ChatParticipants> findByChatId(UUID chatId);
	public List<ChatParticipants> findByChatIdAndUserIdIn(UUID chatId, List<UUID> userId);
}
