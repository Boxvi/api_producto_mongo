package me.boris.bqmongo.repository;

import me.boris.bqmongo.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Productos, String> {
}
