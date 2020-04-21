package id.co.djinggoo.introkafka.model.categoryproduct;

import id.co.djinggoo.introkafka.model.base.BaseMaster;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "category_product")
public class CategoryProduct extends BaseMaster {

    @Column (name = "name") private String name;
    @Column (name = "description") private String description;

}
