package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.ComplaintRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplaintService {
    private ComplaintRepo complaintRepo;

    @Autowired
    public ComplaintService(ComplaintRepo complaintRepo) {
        this.complaintRepo = complaintRepo;
    }

    public List<Complaint> todos() {
        return complaintRepo.todos();
    }

    public List<Complaint> especifico(String title, String comment) {
        return complaintRepo.especifico(title, comment);
    }

    public boolean removeTodos() {
        return complaintRepo.removeTodos();
    }

    public boolean cadastrar(Complaint complaint) {
        return complaintRepo.cadastrar(complaint);
    }
}