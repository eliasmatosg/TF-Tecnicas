package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.District;
import TF01.TF.Business.Repositories.DistrictRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistrictService {
    private DistrictRepo districtRepo;

    @Autowired
    public DistrictService(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }

    public List<District> todos() {
        return districtRepo.todos();
    }

    public List<District> especifico(String name) {
        return districtRepo.especifico(name);
    }

    public boolean removeTodos() {
        return districtRepo.removeTodos();
    }

    public boolean cadastrar(District district) {
        return districtRepo.cadastrar(district);
    }
}