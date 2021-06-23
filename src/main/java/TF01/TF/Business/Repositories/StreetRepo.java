package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface StreetRepo {
    List<Street> todos();
    List<Street> especifico(District district );
    boolean removeTodos();
    boolean cadastrar(District district);
}