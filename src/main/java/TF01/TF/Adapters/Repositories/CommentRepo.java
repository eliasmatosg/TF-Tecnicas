package TF01.TF.Adapters.Repositories;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Entities.User;
import TF01.TF.Business.Repositories.ICommentRepo;

@Component
public class CommentRepo implements ICommentRepo{
	private ICommentCRUD commentCrud;
	private IComplaintCRUD complaintCRUD;
	private IUserCRUD userCRUD;

	@Autowired
	public CommentRepo(ICommentCRUD commentCRUD, IComplaintCRUD complaintCRUD, IUserCRUD userCRUD){
		this.commentCrud = commentCRUD;
		this.complaintCRUD = complaintCRUD;
		this.userCRUD = userCRUD;
	}

	@Override
	public List<Comment> allComments() {
		return commentCrud.findAll();
	}

	@Override
	public List<Comment> specificComment(String filter) {
		return commentCrud.findByText(filter);
	}

	@Override
	public void removeAll() {
		commentCrud.deleteAll();
	}

	@Override
	public void removeSpecific(Long id) {
		commentCrud.deleteById(id);
	}

	@Transactional
	@Override
	public boolean register(Long id, Long userId, Comment comment) {
		try {
				Complaint complaint = complaintCRUD.findById(id).get();
				if (!complaint.getHasBeenSolved()){
					User user = userCRUD.findById(userId).get();
					comment.setUser(user);
					comment.setComplaint(complaint);
					System.out.println(comment.getText());
					commentCrud.save(comment);
					complaintCRUD.findById(id).map(target -> {
						target.addComment(comment);
						return target;
					});
					return true;
				}
				return false;
		}
		catch (NoSuchElementException err) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean register(Long complaintId, Long userId, boolean hasBeenSolved, Comment comment){
		try {
			Complaint complaint = complaintCRUD.findById(complaintId).get();
			User user = userCRUD.findById(userId).get();

			if ((user.getIsOfficialOrgan() || userId == complaint.getUser().getId()) && !complaint.getHasBeenSolved()){
				comment.setUser(user);
				comment.setComplaint(complaint);
				commentCrud.save(comment);
				complaintCRUD.findById(complaintId).map(target -> { 
					target.setHasBeenSolved(hasBeenSolved);
					target.addComment(comment);
					if (hasBeenSolved) {
						target.setSolvedByOfficialOrgan(user.getIsOfficialOrgan());
					}
					return target;
				});
				return true;
			}		
			return false;	
		}
		catch (NoSuchElementException err) {
			System.out.println(err.getMessage());
			return false;
		}	
	}
}
