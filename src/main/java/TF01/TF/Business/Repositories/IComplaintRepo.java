package TF01.TF.Business.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.*;

public interface IComplaintRepo {
    List<Complaint> allComplaints();
    Complaint SpecificComplaint(String filter);
    void removeAll();
    void removeSpecific(String id);
    boolean register(Complaint complaint);
    //List<Comment> allComments();
    boolean update(String id, Complaint complaint);
}