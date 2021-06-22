package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface CategoryRepo {
    List<Category> todos();
    List<Category> especifico(String name, Long id);
    void removeTodos();
    boolean cadastra (Long id, Category category);

}