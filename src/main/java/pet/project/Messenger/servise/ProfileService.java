package pet.project.Messenger.servise;

import org.springframework.stereotype.Service;

import pet.project.Messenger.model.Profile;


public interface ProfileService {
	
	Profile findUserProfile(long userId);
}
