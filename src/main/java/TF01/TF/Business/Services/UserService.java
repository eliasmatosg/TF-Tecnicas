package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Application.DTOs.UserDTO;
import TF01.TF.Business.Entities.User;
import TF01.TF.Business.Repositories.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private IUserRepo userRep;

    @Autowired
    public UserService(IUserRepo userRep) {
        this.userRep = userRep;
    }

    public List<UserDTO> allUsers() {
        return userRep.allUsers();
    }

    public List<User> specificUser(String name) {
        return userRep.specificUser(name);
    }

    public Optional<User> findById(Long id){
        return userRep.findById(id);
    }
    

    public void removeAll() {
        userRep.removeAll();
    }

    public void removeSpecific(Long id){
        userRep.removeSpecific(id);
    }

    public boolean register(User user) {
        return userRep.register(user);
    }
}