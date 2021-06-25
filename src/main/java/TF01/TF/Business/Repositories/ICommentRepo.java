package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface ICommentRepo {
    List<Complaint> todos();
    List<Complaint> especifico(String text);
    boolean removeTodos();
    boolean cadastra(Comment comment);
}