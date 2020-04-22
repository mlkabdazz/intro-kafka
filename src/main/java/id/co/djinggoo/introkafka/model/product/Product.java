package id.co.djinggoo.introkafka.model.product;

import id.co.djinggoo.introkafka.model.base.BaseMaster;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product extends BaseMaster {

    @Id private UUID id;
    @Column (name = "name") private String name;
    @Column (name = "description") private String description;
    @Column (name = "price") private Double price;
    @Column (name = "stock") private Long stock;

}
