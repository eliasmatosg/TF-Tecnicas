package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.User;
import TF01.TF.Business.Repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> todos() {
        return userRepo.todos();
    }

    public List<User> especifico(String name) {
        return userRepo.especifico(name);
    }

    public boolean removeTodos() {
        return userRepo.removeTodos();
    }

    public boolean cadastrar(User user) {
        return userRepo.cadastrar(user);
    }
}