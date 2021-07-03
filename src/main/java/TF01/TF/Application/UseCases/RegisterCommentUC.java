package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.CommentService;
import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Entities.User;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegisterCommentUC {
    private ComplaintService complaintService;
	private CommentService commentService;
	private UserService userService;
	
	@Autowired
	public RegisterCommentUC(ComplaintService complaintService, CommentService commentService, UserService userService) {
        this.complaintService = complaintService;
		this.commentService = commentService;
        this.userService = userService;
	}

	public boolean run(Long complaintId, Long userId, boolean hasBeenSolved, Comment comment){
        return commentService.register(complaintId, userId, hasBeenSolved, comment);
	}

    public boolean run(Long id, Long userId, Comment comment){
        return commentService.register(id, userId, comment);
	}
}