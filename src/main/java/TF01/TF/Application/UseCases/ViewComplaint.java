package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;

import TF01.TF.Business.Services.CommentService;
import TF01.TF.Business.Entities.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ViewComplaint {
	private CommentService commentService; 

	@Autowired
	public ViewComplaint(CommentService commentService){
		this.commentService = commentService;
	}

	public List<Comment> run(String filter){
		return commentService.specificComment(filter);
	}
	
	public List<Comment> run(){
		return commentService.allComments();
	}
}
