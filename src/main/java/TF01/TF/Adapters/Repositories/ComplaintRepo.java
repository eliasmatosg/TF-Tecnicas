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

	//!!FAZER PARA O ID TAMBÉM!!
	@Override
	public Optional<Complaint> SpecificComplaint(String filter) {
		return complaintCrud.findById(filter);
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

	//!! IMPLEMENTAR MÉTODOS DE ATUALIZAR DE RECLAMAÇÃO 
	// (UPDATE DOS ATRIBUTOS)!!
	@Override
	public boolean update(String id, Complaint complaint) {
		complaintCrud.findById(id);
		return true;
	}

	//@Override
	//public long count() {
		//long count = complaintCrud.count();
		//return count;
	//}

	//@Override
	//public void deleteById(String id) {
		//complaintCrud.deleteById(id);
	//}

	//@Override
	//public void delete(Complaint entity) {
		//complaintCrud.delete(entity);
	//}

	//@Override
	//public void deleteAll(Iterable<? extends Complaint> entities) {
		//complaintCrud.deleteAll();
	//}

	//@Override
	//public void deleteAll() {
		//complaintCrud.deleteAll();
	//}

	//@Override
	//public List<Complaint> findAll() {
		//return complaintCrud.findAll();
	//}

	//@Override
	//public List<Complaint> findByTitle(String title) {
		//return complaintCrud.findByTitle(title);
	//}

	//@Override
	//public List<Complaint> findByComments(String comments) {
		//return complaintCrud.findByComments(comments);
	//}
}
