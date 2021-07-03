package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.CommentService;
import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Entities.Complaint;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegisterCommentUC {
    private ComplaintService complaintService;
	private CommentService commentService;
	
	@Autowired
	public RegisterCommentUC(ComplaintService complaintService, CommentService commentService) {
        this.complaintService = complaintService;
		this.commentService = commentService;
	}

	public boolean run(Long id, Comment comment, boolean hasBeenSolved){
        Complaint complaint = complaintService.specificComplaint(id).get();
        List<Comment> comments = complaint.comments();
        comments.add(comment);
        if (hasBeenSolved != complaint.getHasBeenSolved()) {
            complaint.toggleHasBeenSolved();
        } 
        return true;
	}

    public boolean run(Long id, Comment comment){
        try {
            Complaint complaint = complaintService.specificComplaint(id).get();
            List<Comment> comments = complaint.comments();
            comments.add(comment);
            return true;
        } catch (NoSuchElementException err) {
            return false;
        }
	}
}