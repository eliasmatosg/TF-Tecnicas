package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Repositories.ICommentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService{
    private ICommentRepo commentRep;

    @Autowired
    public CommentService(ICommentRepo commentRepo) {
        this.commentRep = commentRepo;
    }

    public List<Comment> allComments() {
        return commentRep.allComments();
    }

    public List<Comment> specificComment(String filter) {
        return commentRep.specificComment(filter);
    }

    public void removeTodos() {
        commentRep.removeAll();
    }

    public boolean register(Comment comment) {
        return commentRep.register(comment);
    }
}