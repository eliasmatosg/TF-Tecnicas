package TF01.TF.Business.Services;

import java.util.*;

import TF01.TF.Business.Entities.Category;
import TF01.TF.Business.Repositories.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> todos() {
        return categoryRepo.todos();
    }

    public List<Category> especifico(String name) {
        return categoryRepo.especifico(name);
    }

    public boolean removeTodos() {
        return categoryRepo.removeTodos();
    }

    public boolean cadastrar(Category category) {
        return categoryRepo.cadastrar(category);
    }
}