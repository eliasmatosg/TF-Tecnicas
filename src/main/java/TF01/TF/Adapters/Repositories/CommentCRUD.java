package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentCRUD extends CrudRepository <Comment, String> {
    List<Comment> findAll();
    List<Comment> findByText(String text);

}