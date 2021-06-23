package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface DistrictRepo {
    List<District> todos();
    List<District> especifico(String name);
    boolean removeTodos();
    boolean cadastra (District district);
}