package boxvi.bqmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
public class Productos {

    private String _id;

    private String nombre;
    private String fotoUrl;
    private double precio;
    private int stock;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updateAt;

    public Productos() {
    }

    public double getTotal() {
        return precio * stock;
    }

}
