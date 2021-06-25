package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.District;

import org.springframework.data.repository.CrudRepository;

public interface IDistrictCRUD extends CrudRepository<District, String> {
    List<District> findAll();
    List<District> findByName(String name);
    List<District> findByStreet(String street);

}