package id.co.djinggoo.introkafka.service.flashsale.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.djinggoo.introkafka.model.flashsale.FlashSale;
import id.co.djinggoo.introkafka.model.product.Product;
import id.co.djinggoo.introkafka.repository.flashsale.FlashSaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class FlashSaleConsumer {

    @Autowired
    private FlashSaleRepository flashSaleRepository;

    @KafkaListener(topics = "product", groupId = "product-01")
    public void productSimpleConsume(String message) {
        log.info("message product : "+message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Product product = objectMapper.readValue(message, Product.class);
            if (product.getStock() < 5 ) flashSaleRepository.save(buildFlashSale(product));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private FlashSale buildFlashSale(Product product){
        FlashSale flashSale = new FlashSale();
        flashSale.setId(UUID.randomUUID());
        flashSale.setProductId(product.getId());
        flashSale.setPriceBefore(product.getPrice());
        flashSale.setStock(product.getStock());

        Double discount = (product.getPrice() * 10)/100;
        flashSale.setPriceNow(product.getPrice() - discount);
        flashSale.setCreatedAt(new Date());
        flashSale.setCreatedBy(product.getCreatedBy());

        return flashSale;
    }

}
