package me.boris.bqmongo.service.impl;

import me.boris.bqmongo.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
public abstract class GenericServiceImplement<T, ID extends Serializable> implements GenericService<T, ID> {

    @Autowired
    public abstract CrudRepository<T, ID> crudRepository();

    @Override
    public T save(T t) {
        return crudRepository().save(t);
    }

    @Override
    public Iterable<T> findAll() {
        return crudRepository().findAll();
    }

    @Override
    public void deleteById(ID id) {
        crudRepository().deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return crudRepository().findById(id);
    }

    /*
    @Autowired(required = true)
    public abstract CrudRepository<T, ID> getDao();

    @Override
    @Transactional
    public T save(T t) {
        return getDao().save(t);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return getDao().findAll();
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        getDao().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return getDao().findById(id);
    }
*/

}
