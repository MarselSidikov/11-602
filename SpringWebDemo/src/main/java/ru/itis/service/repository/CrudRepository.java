package ru.itis.service.repository;

import java.util.List;

/**
 * 15.05.2018
 * CrudRepository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CrudRepository<T> {
    List<T> findAll();

    void update(T model);
    void delete(Long id);
    void save(T model);
    T find(Long id);

}
