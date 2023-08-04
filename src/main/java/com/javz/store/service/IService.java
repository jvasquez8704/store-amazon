package com.javz.store.service;

import java.util.List;

public interface IService<T> {
    T create(T obj);
    T update(T obj);
    List<T> getAll();
    T getById(Long id);
    Boolean delete(Long id);
}
