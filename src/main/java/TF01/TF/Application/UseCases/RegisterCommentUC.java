package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.CommentService;
import TF01.TF.Business.Entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegisterCommentUC {
	private CommentService commentService;
	
	@Autowired
	public RegisterCommentUC(CommentService commentService){
		this.commentService = commentService;
	}

	public void run(Comment comment){
		commentService.register(comment);
	}
}