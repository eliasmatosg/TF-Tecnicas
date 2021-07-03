package TF01.TF.Adapters.Repositories;

import java.util.*;

import TF01.TF.Business.Entities.User;

import org.springframework.data.repository.CrudRepository;

public interface IUserCRUD extends CrudRepository<User, String> {
    List<User> findAll();
    List<User> findByName(String name);
    Optional<User> findById(Long id);
    boolean deleteById(Long id);
}