package TF01.TF.Business.Repositories;

import java.util.*;
import TF01.TF.Business.Entities.*;

public interface CommentRepo {
    List<Reclamacoes> todos();
    List<Reclamacoes> especifico(String text);
    void removeTodos();
    boolean cadastra(String text, Comment comment);
}