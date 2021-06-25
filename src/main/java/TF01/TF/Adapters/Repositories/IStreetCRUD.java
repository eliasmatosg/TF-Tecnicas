package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.Street;

import org.springframework.data.repository.CrudRepository;

public interface IStreetCRUD extends CrudRepository <Street, String> {
    List<Street> findAll();
    List<Street> findByName(String name);
    List<Street> findByName(String district);
}