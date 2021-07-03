package TF01.TF.Business.Repositories;

import java.util.*;

import TF01.TF.Application.DTOs.ComplaintDTO;
import TF01.TF.Business.Entities.*;

public interface IComplaintRepo {
    List<Complaint> allComplaints();
    List<ComplaintDTO> allComplaintsDTO();
    Optional<Complaint> SpecificComplaint(Long filter);
    void removeAll();
    void removeSpecific(Long id);
    boolean register(Long userId, Complaint complaint);
    //List<Comment> allComments();
    boolean update(Long id, Complaint complaint);
}