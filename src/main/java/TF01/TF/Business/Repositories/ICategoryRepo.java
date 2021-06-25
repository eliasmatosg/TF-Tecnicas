package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ICategoryRepo {
    List<Category> todos();
    List<Category> especifico(String name);
    boolean removeTodos();
    boolean cadastra (Category category);
}