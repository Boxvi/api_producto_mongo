package boxvi.bqmongo.service;

import boxvi.bqmongo.model.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductosService {

    List<Productos> findAll();

    Optional<Productos> findById(String _id);

    Productos save(Productos producto);

    boolean deleteById(String _id);

}
