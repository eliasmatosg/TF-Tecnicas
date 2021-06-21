package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface OfficialOrganRepo {
    List<OfficialOrgan> todos();
    List<OfficialOrgan> todos(String name, long id);
    boolean cadastra(String name, long id, OfficialOrgan officialOrgan);

}