package me.boris.bqmongo.service.impl;

import me.boris.bqmongo.model.Producto;
import me.boris.bqmongo.repository.ProductoRepository;
import me.boris.bqmongo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplement extends GenericServiceImplement<Producto,Integer> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> crudRepository() {
        return productoRepository;
    }

}


    /*
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImplement() {
    }

    /*
    public ProductoServiceImplement(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }*/