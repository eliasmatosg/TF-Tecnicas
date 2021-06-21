package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ComplaintRepo {
    List<Complaint> todos();
    List<Complaint> todos(String title, String comment );
    boolean cadastra (String title, String comment, Complaint complaint);
    
}