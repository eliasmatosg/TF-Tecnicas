package TF01.TF.Adapters.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import TF01.TF.Business.Entities.User;
import TF01.TF.Application.DTOs.UserDTO;
import TF01.TF.Business.Entities.*;
import TF01.TF.Business.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepo implements IUserRepo {
    private IUserCRUD userCrud;

    @Autowired

    public UserRepo(IUserCRUD userCrud) {
        this.userCrud = userCrud;
        
    }

    @Override
    public List<UserDTO> allUsers() {
        List<UserDTO> users = new ArrayList<UserDTO>();
        userCrud.findAll()
        .stream()
        .forEach(s -> users.add(new UserDTO(s.getName(), s.getIsAdmin(), s.getIsOfficialOrgan())));
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userCrud.findById(id);
    }

    @Override
    public List<User> specificUser(String filter) {
        return userCrud.findByName(filter);
    }

    @Override
    public void removeAll() {
        userCrud.deleteAll();
    }

    @Override
    public void removeSpecific(Long id) {
        userCrud.deleteById(id);
    }

    @Override
    public boolean register(User user) {
        userCrud.save(user);
        return true;
    }
}
