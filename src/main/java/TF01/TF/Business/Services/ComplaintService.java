package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.IComplaintRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplaintService {
    private IComplaintRepo complaintRep;

    @Autowired
    public ComplaintService(IComplaintRepo complaintRep) {
        this.complaintRep = complaintRep;
    }

    public List<Complaint> allComplaints() {
        return complaintRep.allComplaints();
    }

    public List<Complaint> specificComplaint(String filter) {
        return complaintRep.SpecificComplaint(filter);
    }

    public void removeAll() {
        complaintRep.removeAll();
    }

    public boolean register(Complaint complaint) {
        return complaintRep.register(complaint);
    }

    public List<Comment> getComments(){
        return complaintRep.allComments();
    }
}