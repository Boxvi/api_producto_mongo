package me.boris.bqmongo.controller;

import me.boris.bqmongo.model.Producto;
import me.boris.bqmongo.service.impl.ProductoServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    public ProductoServiceImplement productoServiceImplement;


    private Optional<Producto> productoOptional;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productoOptional = productoServiceImplement.findById(id);
        if (productoOptional.isPresent()) {
            productoServiceImplement.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Producto> findAll() {
        return StreamSupport.stream(productoServiceImplement.findAll().spliterator(), false).collect(Collectors.toList());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Producto producto) {
        productoOptional = productoServiceImplement.findById(id);

        if (productoOptional.isPresent()) {
            productoOptional.get().setNombre(producto.getNombre());
            productoOptional.get().setPrecio(producto.getPrecio());
            productoOptional.get().setStock(producto.getStock());
            productoOptional.get().setFotoUrl(producto.getFotoUrl());
            return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImplement.save(productoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
