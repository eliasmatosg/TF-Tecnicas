package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface CommentRepo {
    List<Reclamacoes> todos();
    List<Reclamacoes> todos(String name);
    void removeTodos();
    boolean cadastra(String name, Comment comment);

}