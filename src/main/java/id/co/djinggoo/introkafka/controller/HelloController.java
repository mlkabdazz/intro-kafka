package id.co.djinggoo.introkafka.controller;

import id.co.djinggoo.introkafka.model.common.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloController {

    @GetMapping("hello")
    @ResponseStatus(code = HttpStatus.OK)
    public Hello hello(){
        Hello hello = new Hello();
        hello.setResult("Hello malik");
       return hello;
    }

}
