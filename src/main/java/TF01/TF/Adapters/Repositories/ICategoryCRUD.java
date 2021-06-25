package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryCRUD extends CrudRepository <Category, Long> {
    List<Category> findAll();
    List<Category> findById(Long id);

}

