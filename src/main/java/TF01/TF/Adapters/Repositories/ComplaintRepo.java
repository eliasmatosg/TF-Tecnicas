package TF01.TF.Adapters.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.IComplaintRepo;

@Component
public class ComplaintRepo implements IComplaintRepo{
	private IComplaintCRUD complaintCrud;
	
	@Autowired
	public ComplaintRepo(IComplaintCRUD complaintCRUD){
		this.complaintCrud = complaintCRUD;
	}

	@Override
	public List<Complaint> allComplaints() {
		return complaintCrud.findAll();
	}

	@Override
	public Complaint SpecificComplaint(String filter) {
		return complaintCrud.findById(filter).get();
	}

	@Override
	public void removeAll() {
		complaintCrud.deleteAll();
	}

	@Override
	public void removeSpecific(String id) {
		complaintCrud.deleteById(id);
	}

	@Override
	public boolean register(Complaint complaint) {
		complaintCrud.save(complaint);
		return true;
	}

	@Override
	public boolean update(String id, Complaint complaint) {
				Complaint compl = complaintCrud.findById(id).get();
        compl.setCategory(complaint.getCategory());
        compl.setDate(complaint.getDate());
        compl.setDescription(complaint.getDescription());
        compl.setDistrict(complaint.getDistrict());
        compl.setImageLink(complaint.getImageLink());
        compl.setStreet(complaint.getAddress());
        compl.setTitle(complaint.getTitle());
		return true;
	}
}
