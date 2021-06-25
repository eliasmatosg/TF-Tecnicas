package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.Complaint;

import org.springframework.data.repository.CrudRepository;

public interface IComplaintCRUD extends CrudRepository<Complaint, String> {
    List<Complaint> findAll();
    List<Complaint> findByTitle(String title);
    List<Complaint> findByComment(String comment);

}