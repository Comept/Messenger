package pet.project.Messenger.servise.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pet.project.Messenger.model.Profile;
import pet.project.Messenger.repository.ProfileRepository;
import pet.project.Messenger.servise.ProfileService;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileRepository profileRepository;

	@Override
	public Profile findUserProfile(long userId) {
		Optional<Profile> profile = profileRepository.findByIdWithUser(userId);
		if (profile.isEmpty()) return new Profile();
		return profile.get();
	}
	
	
}
