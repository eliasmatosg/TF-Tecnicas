package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface IUserRepo {
    List<User> allUsers();
    List<User> specificUser(String filter);
    void removeAll();
    void removeSpecific(String id);
    boolean register(User user);
}