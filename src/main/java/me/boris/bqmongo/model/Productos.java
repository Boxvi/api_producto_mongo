package me.boris.bqmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Productos {

//    @Id
//    private Integer id;

    private String nombre;
    private String fotoUrl;
    private double precio;
    private int stock;

}
