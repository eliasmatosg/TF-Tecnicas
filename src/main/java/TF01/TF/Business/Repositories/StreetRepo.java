package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface StreetRepo {
    List<Street> todos();
    List<Street> especifico(String name);
    boolean removeTodos();
    boolean cadastrar(Street street);
}