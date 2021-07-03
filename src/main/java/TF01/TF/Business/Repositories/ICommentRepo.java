package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ICommentRepo {
    List<Comment> allComments();
    List<Comment> specificComment(String filter);
    void removeAll();
    void removeSpecific(Long id);
    boolean register(Long id, Comment comment);
}