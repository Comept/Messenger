package pet.project.Messenger.repository.dao.jdbc;

import org.springframework.stereotype.Repository;

import pet.project.Messenger.repository.dao.ChatsDao;

@Repository
public class ChatsRepo {

	private final ChatsDao chatsDao;

	public ChatsRepo(ChatsDao chatsDao) {
		super();
		this.chatsDao = chatsDao;
	}

}
