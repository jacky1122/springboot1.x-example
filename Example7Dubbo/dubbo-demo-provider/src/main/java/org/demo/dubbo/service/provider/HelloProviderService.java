package org.demo.dubbo.service.provider;

import org.demo.dubbo.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * HelloProviderService
 */
@Service
public class HelloProviderService  implements IHelloService{

    @Override
    public String hello(String name) {
        return "Hello "+ name;
    }



}