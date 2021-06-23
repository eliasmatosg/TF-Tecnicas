package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Comment;
import TF01.TF.Business.Repositories.CommentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {
    private CommentRepo Comment;

    @Autowired
    public DistrictService(CommentRepo Comment) {
        this.Comment = Comment;
    }

    public List<Comment> todos() {
        return Comment.todos();
    }

    public List<Comment> especifico(String text) {
        return Comment.especifico(text);
    }

    public boolean removeTodos() {
        return Comment.removeTodos();
    }

    public boolean cadastrar(Comment comment) {
        return Comment.cadastrar(comment);
    }
}