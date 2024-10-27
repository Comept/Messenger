package pet.project.Messenger.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import pet.project.Messenger.model.Message;

public class ChatDto {

	private UUID userId;
	private List<ChatParticipantsDto> members = new ArrayList();
	private List<Message> messages; 
	private String chatName;
	
	public String getParticipantUsernameById(UUID id) {
		String a = "";
		Iterator<ChatParticipantsDto> memberIter = members.iterator();
		while(memberIter.hasNext()) {
			ChatParticipantsDto member = memberIter.next();
			if(member.getUserId() == id) return member.getUsername();
			a += member.getUserId() + "   ";
		}
		return a;
	}
	
	
}
