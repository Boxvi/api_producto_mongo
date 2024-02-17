package boxvi.bqmongo.repository;

import boxvi.bqmongo.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends MongoRepository<Productos, String> {
}
