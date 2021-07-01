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

    public Complaint specificComplaint(String filter) {
        return complaintRep.SpecificComplaint(filter);
    }

    public void removeAll() {
        complaintRep.removeAll();
    }

    public void removeSpecific(String id){
        complaintRep.removeSpecific(id);
    }

    public boolean register(Complaint complaint) {
        return complaintRep.register(complaint);
    }

    public boolean update(String id, Complaint complaint){
        return complaintRep.update(id, complaint);
    }
}