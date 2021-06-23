package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface UserRepo {
    List<User> todos();
    List<User> especifico(String name);
    boolean removeTodos();
    boolean cadastra(User user);
}
    
