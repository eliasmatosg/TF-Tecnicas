package TF01.TF.Adapters.Repositories;

import java.util.List;
import java.util.stream.Collectors;

import TF01.TF.Business.Entities.User;
import TF01.TF.Business.Entities.*;
import TF01.TF.Business.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepo implements IUserRepo {
    private IUserCRUD userCRUD;

    @Autowired

    public UserRepo(IUserCRUD UserCrud ) {
        this.userCRUD = userCRUD;
        
    }

    public List<User> todos() {
        List<User> resp = userCRUD.findAll();
        return resp;

    }

    public List<User> especifico(String name) {
        List<User> resp = userCRUD.findByName(name);
        return resp;

    }

    public void removeTodos(){
        userCRUD.deleteAll();

    }

    public boolean cadastra(User user){
        userCRUD.save(user);
        return true;

    }

    @Override
    public List<User> allUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> specificUser(String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeSpecific(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean register(User user) {
        // TODO Auto-generated method stub
        return false;
    }
}
