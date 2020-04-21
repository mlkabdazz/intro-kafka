package id.co.djinggoo.introkafka.service.product.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.djinggoo.introkafka.model.product.ProductDto;
import id.co.djinggoo.introkafka.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProductProducer {

    @Value("${topic.product}")
    private String topicProduct;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendSimpleMessage(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<id.co.djinggoo.introkafka.model.domain.Product> products = productRepository.findAll();

        try {
            for (id.co.djinggoo.introkafka.model.domain.Product product : products) {
                kafkaTemplate.send(topicProduct, objectMapper.writeValueAsString(product));
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
