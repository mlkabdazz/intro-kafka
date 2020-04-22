package id.co.djinggoo.introkafka.model.flashsale;

import id.co.djinggoo.introkafka.model.base.BaseTemp;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name="flash_sale")
public class FlashSale extends BaseTemp {

    @Column (name="product_id") UUID productId;
    @Column(name="stock") Long stock;
    @Column (name="price_before") Double priceBefore;
    @Column (name="price_now") Double priceNow;

}
