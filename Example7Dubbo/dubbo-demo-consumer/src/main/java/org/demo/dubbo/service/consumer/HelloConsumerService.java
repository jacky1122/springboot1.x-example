package org.demo.dubbo.service.consumer;

import org.demo.dubbo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HelloConsumerService
 */
@Service
public class HelloConsumerService {
    @Autowired
    private IHelloService helloService;

    public String sayHello(String name){
        return helloService.hello(name);
    }
    
}