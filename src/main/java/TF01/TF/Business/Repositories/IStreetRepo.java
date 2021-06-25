package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface IStreetRepo {
    List<Street> todos();
    List<Street> especifico(String name);
    boolean removeTodos();
    boolean cadastrar(Street street);
}