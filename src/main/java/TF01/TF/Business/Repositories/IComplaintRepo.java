package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface IComplaintRepo {
    List<Complaint> allComplaints();
    List<Complaint> SpecificComplaint(String filter);
    void removeAll();
    void removeSpecific(Long id);
    boolean register(Complaint complaint);
    List<Comment> allComments();
}