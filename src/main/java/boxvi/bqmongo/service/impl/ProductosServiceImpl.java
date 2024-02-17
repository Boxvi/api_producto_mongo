package boxvi.bqmongo.service.impl;

import boxvi.bqmongo.model.Productos;
import boxvi.bqmongo.repository.ProductosRepository;
import boxvi.bqmongo.service.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductosServiceImpl implements ProductosService {

    private ProductosRepository productosRepository;

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Optional<Productos> findById(String _id) {
        return productosRepository.findById(_id);
    }

    @Override
    public Productos save(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public boolean deleteById(String _id) {
        Optional<Productos> productosOptional = productosRepository.findById(_id);
        if (productosOptional.isPresent()) {
            productosRepository.deleteById(_id);
            return true;
        } else {
            return false;
        }
    }
}
