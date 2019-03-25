package org.demo.dubbo.web;

import org.demo.dubbo.service.consumer.HelloConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * HelloController
 */
@RestController
public class HelloController {

    @Autowired
    private HelloConsumerService helloService; 

    @GetMapping(value="/hello")
    public String hello(@RequestParam String name) {
        return helloService.sayHello(name);
    }
    
    
}