package com.javz.store.service.impl;

import com.javz.store.model.Category;
import com.javz.store.repo.ICategoryRepo;
import com.javz.store.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepo repo;
    @Override
    public Category create(Category category) {
        category.setCreatedAt(LocalDateTime.now());
        category.setDeleted(Boolean.FALSE);
        return repo.save(category);
    }

    @Override
    public Category update(Category category) {
        category.setUpdatedAt(LocalDateTime.now());
        return repo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return  repo.findAll();
    }

    @Override
    public Category getById(Long id) {
        Optional<Category> cat = repo.findById(id);
        return cat.orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
