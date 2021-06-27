package TF01.TF.Adapters.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Business.Entities.Complaint;

@Component
public class ComplaintRepo implements IComplaintCRUD{
	private IComplaintCRUD complaintCrud;
	
	@Autowired
	public ComplaintRepo(IComplaintCRUD complaintCRUD){
		this.complaintCrud = complaintCRUD;
	}

	@Override
	public <S extends Complaint> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Complaint> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Complaint> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Complaint> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		long count = complaintCrud.count();
		return count;
	}

	@Override
	public void deleteById(String id) {
		complaintCrud.deleteById(id);
	}

	@Override
	public void delete(Complaint entity) {
		complaintCrud.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Complaint> entities) {
		complaintCrud.deleteAll();
	}

	@Override
	public void deleteAll() {
		complaintCrud.deleteAll();
	}

	@Override
	public List<Complaint> findAll() {
		return complaintCrud.findAll();
	}

	@Override
	public List<Complaint> findByTitle(String title) {
		return complaintCrud.findByTitle(title);
	}

	@Override
	public List<Complaint> findByComments(String comments) {
		return complaintCrud.findByComments(comments);
	}
}
