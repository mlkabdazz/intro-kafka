package id.co.djinggoo.introkafka.repository.flashsale;

import id.co.djinggoo.introkafka.model.flashsale.FlashSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlashSaleRepository extends JpaRepository<FlashSale, UUID> {
}
