package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface StreetRepo {
    List<Street> todos();
    List<Street> especifico(String name, District district );
    void removeTodos();
    boolean cadastrar(String name, District district, Street street);

}