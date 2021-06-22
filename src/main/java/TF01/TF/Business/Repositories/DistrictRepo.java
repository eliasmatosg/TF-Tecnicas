package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface DistrictRepo {
    List<District> todos();
    List<District> todos(String name, String Street);
    void removeTodos();
    boolean cadastra (String name, String Street, District district);

}