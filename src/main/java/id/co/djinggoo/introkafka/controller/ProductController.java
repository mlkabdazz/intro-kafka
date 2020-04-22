package id.co.djinggoo.introkafka.controller;

import id.co.djinggoo.introkafka.model.common.ResponseDto;
import id.co.djinggoo.introkafka.service.product.producer.ProductProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductProducer productProducer;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/producer/sendsimplemessage")
    public ResponseDto sendSimpleMessage(){
        try {
            productProducer.sendSimpleMessage();
            return new ResponseDto("success to send message to product topic", "Success");
        }catch (IllegalArgumentException e){
            return new ResponseDto("Failed to send message to product topic", "Failed");
        }catch (Exception e){
            return new ResponseDto(e.getMessage(), "Failed");
        }
    }

}
