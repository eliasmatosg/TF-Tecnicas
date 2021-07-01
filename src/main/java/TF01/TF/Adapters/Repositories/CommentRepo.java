package TF01.TF.Adapters.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.ICommentRepo;

@Component
public class CommentRepo implements ICommentRepo{
	private ICommentCRUD commentCrud;
	private IComplaintCRUD complaintCRUD;

	@Autowired
	public CommentRepo(ICommentCRUD commentCRUD, IComplaintCRUD complaintCRUD){
		this.commentCrud = commentCRUD;
		this.complaintCRUD = complaintCRUD;
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
	public void removeSpecific(String id) {
		commentCrud.deleteById(id);
	}

	@Override
	public boolean register(String id, Comment comment) {
		Complaint target = complaintCRUD.findById(id).get();
		target.comments().add(comment);
		return true;
	}
}
