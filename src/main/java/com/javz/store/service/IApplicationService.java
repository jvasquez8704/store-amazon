package com.javz.store.service;

import com.javz.store.model.Application;
import com.javz.store.model.Category;

import java.util.List;

public interface IApplicationService extends IService<Application> {
    List<Application> getApplicationsByCategory(Long categoryId);
}
