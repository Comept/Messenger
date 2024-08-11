package pet.project.Messenger.servise;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.ChatsRepository;

@Repository
public class ChatsRepo {

	private final ChatsRepository chatsRepository;

	public ChatsRepo(ChatsRepository chatsRepository) {
		super();
		this.chatsRepository = chatsRepository;
	}

}
