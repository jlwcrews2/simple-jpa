package no.jlwcrews.simplejpa.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepo repo;

    @Autowired
    public ProfileService(ProfileRepo repo) {
        this.repo = repo;
    }

    public List<Profile> getProfiles() {
        return repo.findAll();
    }

    public Profile getProfileById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) {
        return repo.save(profile);
    }

    public void deleteProfileById(Long id){
        repo.deleteById(id);
    }
}
