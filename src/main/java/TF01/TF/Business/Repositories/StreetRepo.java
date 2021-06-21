package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface StreetRepo {
    List<Street> todos();
    List<Street> todos(String name, District district );
    boolean cadastrar(String name, District district, Street street);

}