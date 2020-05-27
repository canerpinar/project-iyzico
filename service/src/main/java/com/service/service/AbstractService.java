package com.service.service;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractService<T,ID>{

    private CrudRepository<T,ID> crudRepository;

    public AbstractService(CrudRepository<T,ID> crudRepository) {
        this.crudRepository = crudRepository;
    }


    public T save(T t) {
        return (T) crudRepository.save(t);
    }


    public void delete(T t) {
        crudRepository.delete(t);
    }


    public T findById(ID id) {
        return (T) crudRepository.findById(id);
    }


}
