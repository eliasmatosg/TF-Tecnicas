package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ComplaintRepo {
    List<Complaint> todos();
    List<Complaint> especifico(String title, String comment );
    void removeTodos();
    boolean cadastra (String title, String comment, Complaint complaint);
    
}