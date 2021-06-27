package TF01.TF.Business.Services;

import java.util.*;

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

    public List<User> allUsers() {
        return userRep.allUsers();
    }

    public List<User> specificUser(String filter) {
        return userRep.specificUser(filter);
    }

    public void removeAll() {
        userRep.removeAll();
    }

    public void removeSpecific(String id){
        userRep.removeSpecific(id);
    }

    public boolean register(User user) {
        return userRep.register(user);
    }
}