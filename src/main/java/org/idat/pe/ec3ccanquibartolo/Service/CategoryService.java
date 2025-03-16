package org.idat.pe.ec3ccanquibartolo.Service;

/*
import com.example.store.exception.ResourceNotFoundException;
import com.example.store.model.Category;
import com.example.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 */

import org.idat.pe.ec3ccanquibartolo.Exception.ResourceNotFoundException;
import org.idat.pe.ec3ccanquibartolo.Model.Category;
import org.idat.pe.ec3ccanquibartolo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
