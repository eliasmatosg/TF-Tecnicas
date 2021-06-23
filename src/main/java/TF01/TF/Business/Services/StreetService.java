package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Street;
import TF01.TF.Business.Repositories.StreetRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreetService {
    private StreetRepo districtRepo;

    @Autowired
    public StreetService(StreetRepo streetRepo) {
        this.streetRepo = streetRepo;
    }

    public List<District> todos() {
        return streetRepo.todos();
    }

    public List<District> especifico(String name) {
        return streetRepo.especifico(name);
    }

    public boolean removeTodos() {
        return streetRepo.removeTodos();
    }

    public boolean cadastrar(Street street) {
        return streetRepo.cadastrar(street);
    }
}