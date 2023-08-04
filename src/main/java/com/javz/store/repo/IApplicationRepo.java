package com.javz.store.repo;

import com.javz.store.model.Application;
import com.javz.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApplicationRepo extends JpaRepository<Application, Long> {
    List<Application> getApplicationsByCategory(Category category);
}
