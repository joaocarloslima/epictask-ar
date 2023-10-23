package br.com.fiap.epictask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void addScore(User user, Integer score) {
        var userDb = repository.findById(user.getId()).get();
        if (userDb.getScore() == null) userDb.setScore(0);
        userDb.setScore(userDb.getScore() + score);
        repository.save(userDb);
    }

}
