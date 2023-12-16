package me.boris.bqmongo.dto;

import lombok.Data;

@Data
public class ProductosDto {

    private String nombre;
    private String fotoUrl;
    private double precio;
    private int stock;

}
