package com.javz.store.service.impl;

import com.javz.store.model.Application;
import com.javz.store.model.Category;
import com.javz.store.repo.IApplicationRepo;
import com.javz.store.service.IApplicationService;
import com.javz.store.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    IApplicationRepo repo;

    @Autowired
    ICategoryService catService;

    @Override
    public Application create(Application application) {
        application.setCreatedAt(LocalDateTime.now());
        application.setDeleted(Boolean.FALSE);
        return repo.save(application);
    }

    @Override
    public Application update(Application application) {
        application.setUpdatedAt(LocalDateTime.now());
        return repo.save(application);
    }

    @Override
    public List<Application> getAll() {
        return repo.findAll();
    }

    @Override
    public Application getById(Long id) {
        Optional<Application> application = repo.findById(id);
        return application.orElse(null);
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

    @Override
    public List<Application> getApplicationsByCategory(Long categoryId) {
        Category cat = catService.getById(categoryId);
        return repo.getApplicationsByCategory(cat);
    }
}
