package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ICommentRepo {
    List<Comment> allComments();
    List<Comment> specificComment(String filter);
    void removeAll();
    void removeSpecific(String id);
    boolean register(String id, Comment comment);
}