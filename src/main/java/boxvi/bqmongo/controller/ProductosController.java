package boxvi.bqmongo.controller;

import boxvi.bqmongo.config.ResponseMessage;
import boxvi.bqmongo.dto.ProductosDto;
import boxvi.bqmongo.model.Productos;
import boxvi.bqmongo.service.ProductosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/productos")
@AllArgsConstructor
public class ProductosController {

    private ProductosService productosService;
    private ResponseMessage responseMessage;
    private Optional<Productos> productosOptional;

    @GetMapping
    public List<Productos> findAll() {
        return productosService.findAll();
    }

    @GetMapping("{_id}")
    public ResponseEntity<?> findById(@PathVariable String _id) {
        productosOptional = productosService.findById(_id);
        if (productosOptional.isPresent()) {
            responseMessage = new ResponseMessage("Productos encontrados", "Se encontraron los productos", "success", productosService.findById(_id));
        } else {
            responseMessage = new ResponseMessage("Productos no encontrados", "No se encontraron los productos", "error", new Productos());
        }
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductosDto.Create productoDto) {
        Productos productos = new Productos();
        productos.setNombre(productoDto.getNombre());
        productos.setFotoUrl(productoDto.getFotoUrl());
        productos.setPrecio(productoDto.getPrecio());
        productos.setStock(productoDto.getStock());
        responseMessage = new ResponseMessage("Producto guardado", "Se guardo el producto", "success", productosService.save(productos));
        return ResponseEntity.ok(responseMessage);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductosDto.Update productoDto) {
        productosOptional = productosService.findById(productoDto.getId());
        if (productosOptional.isPresent()) {
            productosOptional.get().setNombre(productoDto.getNombre());
            productosOptional.get().setFotoUrl(productoDto.getFotoUrl());
            productosOptional.get().setPrecio(productoDto.getPrecio());
            productosOptional.get().setStock(productoDto.getStock());
            responseMessage = new ResponseMessage("Producto actualizado", "Se actualizo el producto", "success", productosService.save(productosOptional.get()));
        } else {
            responseMessage = new ResponseMessage("Producto no encontrado", "No se encontro el producto", "error", new Productos());
        }
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("{_id}")
    public ResponseEntity<?> delete(@PathVariable String _id) {
        if (productosService.deleteById(_id)) {
            responseMessage = new ResponseMessage("Producto eliminado", "Se elimino el producto", "success", new Productos());
        } else {
            responseMessage = new ResponseMessage("Producto no encontrado", "No se encontro el producto", "error", new Productos());
        }
        return ResponseEntity.ok(responseMessage);
    }

}
