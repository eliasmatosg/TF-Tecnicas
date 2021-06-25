package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface IComplaintRepo {
    List<Complaint> todos();
    List<Complaint> especifico(String title, String comment);
    boolean removeTodos();
    boolean cadastra (Complaint complaint);
}