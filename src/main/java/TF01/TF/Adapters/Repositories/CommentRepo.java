package TF01.TF.Adapters.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Repositories.ICommentRepo;

@Component
public class CommentRepo implements ICommentRepo{
	private ICommentCRUD commentCrud;

	@Autowired
	public CommentRepo(ICommentCRUD commentCRUD){
		this.commentCrud = commentCRUD;
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
	public boolean register(Comment comment) {
		commentCrud.save(comment);
		return true;
	}
	
}
