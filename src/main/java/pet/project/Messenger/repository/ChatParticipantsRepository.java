package pet.project.Messenger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pet.project.Messenger.model.ChatParticipants;
import pet.project.Messenger.model.PrimeryKeyses.ChatPartricipantsPK;

public interface ChatParticipantsRepository extends CrudRepository<ChatParticipants,ChatPartricipantsPK>{
	public ChatParticipants findByChatIdAndUserId(long userId, long chatId);
	public List<ChatParticipants> findChatIsByUserId(long userId);
	public List<ChatParticipants> findByChatId(long chatId);
	public List<ChatParticipants> findByChatIdAndUserIdIn(long chatId, List<Long> userId);
}
