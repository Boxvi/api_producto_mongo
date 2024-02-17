package boxvi.bqmongo.dto;

import lombok.Data;

public class ProductosDto {

    @Data
    public static class Create {
        private String nombre;
        private String fotoUrl;
        private double precio;
        private int stock;
    }

    @Data
    public static class Update {
        private String id;
        private String nombre;
        private String fotoUrl;
        private double precio;
        private int stock;
    }
}
