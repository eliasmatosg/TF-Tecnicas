package TF01.TF.Adapters.Repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Application.DTOs.CommentDTO;
import TF01.TF.Application.DTOs.ComplaintDTO;
import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.User;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.IComplaintRepo;

@Component
public class ComplaintRepo implements IComplaintRepo{
	private IComplaintCRUD complaintCrud;
	private IUserCRUD userCrud;
	
	@Autowired
	public ComplaintRepo(IComplaintCRUD complaintCRUD, IUserCRUD userCRUD){
		this.complaintCrud = complaintCRUD;
		this.userCrud = userCRUD;
	}

	@Override
	public List<ComplaintDTO> allComplaintsDTO() {
		List<ComplaintDTO>list = new ArrayList<ComplaintDTO>();
		complaintCrud.findAll()
		.stream()
		.forEach(s -> {
			List<CommentDTO> commentsDTO = new ArrayList<>();
			s.getComments().stream().forEach(t -> {
				CommentDTO newComment = new CommentDTO(t.getUser().getName(), t.getText(), t.getImageLink());
				commentsDTO.add(newComment);
			});
			ComplaintDTO newDTO = new ComplaintDTO(s.getTitle(), s.getDescription(),
													s.getDate().toString(), s.getHasBeenSolved(), s.getCategory(),
													s.getAddress(), s.getUser().getName(), s.getImageLink(), s.getDistrict(),
													s.getId(), commentsDTO);	
															list.add(newDTO);
		}
						);
    return list;
	}

	@Override
	public List<Complaint> allComplaints() {
		return complaintCrud.findAll();
	}

	@Override
	public Optional<Complaint> SpecificComplaint(Long filter) {
		return complaintCrud.findById(filter);
	}

	@Override
	public void removeAll() {
		complaintCrud.deleteAll();
	}

	@Override
	public void removeSpecific(Long id) {
		complaintCrud.deleteById(id);
	}

	@Override
	public boolean register(Long userId, Complaint complaint) {
		User user = userCrud.findById(userId).get();
		if (user != null){
			complaint.setUser(user);
			complaint.setDate(new Date());
			complaint.setNotSolved();
			complaintCrud.save(complaint);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void update(Long id, Long userId, Complaint complaint) {
				complaintCrud.findById(id).
				map(target -> { if (!target.getHasBeenSolved() && target.getUser().getId() == userId) {
					target.setTitle(complaint.getTitle());
					target.setDescription(complaint.getDescription());
					target.setImageLink(complaint.getImageLink());
					target.setCategory(complaint.getCategory());
					target.setHasBeenSolved(complaint.getHasBeenSolved());
					target.setDistrict(complaint.getDistrict());
					target.setAddress(complaint.getAddress());
					target.setHasBeenSolved(complaint.getHasBeenSolved());
					return target;
				} return target;
				});
	}
}
