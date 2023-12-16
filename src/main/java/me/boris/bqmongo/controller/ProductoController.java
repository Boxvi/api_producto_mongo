package me.boris.bqmongo.controller;

import me.boris.bqmongo.dto.ProductosDto;
import me.boris.bqmongo.model.Productos;
import me.boris.bqmongo.service.impl.ProductoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    public final ProductoServiceImplement productoServiceImplement;
    private Optional<Productos> productoOptional;
    public ProductoController(ProductoServiceImplement productoServiceImplement) {
        this.productoServiceImplement = productoServiceImplement;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductosDto productos) {

        Productos producto = new Productos();
        producto.setNombre(productos.getNombre());
        producto.setFotoUrl(productos.getFotoUrl());
        producto.setPrecio(productos.getPrecio());
        producto.setStock(productos.getStock());

        return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            productoServiceImplement.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public Iterable<Productos> findAll() {
        return productoServiceImplement.findAll();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ProductosDto productos) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            productoOptional.get().setNombre(productos.getNombre());
            productoOptional.get().setPrecio(productos.getPrecio());
            productoOptional.get().setStock(productos.getStock());
            productoOptional.get().setFotoUrl(productos.getFotoUrl());
            return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(productoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
