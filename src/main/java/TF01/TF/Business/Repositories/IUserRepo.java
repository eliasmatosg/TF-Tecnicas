package TF01.TF.Business.Repositories;

import java.util.*;

import TF01.TF.Application.DTOs.UserDTO;
import TF01.TF.Business.Entities.*;

public interface IUserRepo {
    List<UserDTO> allUsers();
    List<User> specificUser(String filter);
    void removeAll();
    void removeSpecific(Long id);
    boolean register(User user);
    Optional<User> findById(Long id);
}