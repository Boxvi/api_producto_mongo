package me.boris.bqmongo.service.impl;

import me.boris.bqmongo.model.Productos;
import me.boris.bqmongo.repository.ProductoRepository;
import me.boris.bqmongo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplement extends GenericServiceImplement<Productos,String> implements ProductoService {
    private final ProductoRepository productoRepository;
    public ProductoServiceImplement(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @Override
    public CrudRepository<Productos, String> crudRepository() {
        return productoRepository;
    }
}
