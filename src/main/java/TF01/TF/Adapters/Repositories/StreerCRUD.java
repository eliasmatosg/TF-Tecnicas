package TF01.TF.Adapters.Repositories;

import java.ultil.*;

import TF01.TF.Business.Entities.Street;

import org.springframework.data.repository.CrudRepository;

public interface StreetCRUD extends CrudRepository <Street, String> {
    List<Street> findAll();
    List<Street> findByName(String name);
    List<Street> findByName(String district)
}