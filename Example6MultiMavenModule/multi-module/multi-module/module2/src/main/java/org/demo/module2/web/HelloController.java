package org.demo.module2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
public class HelloController {

    @GetMapping
    public String module2(){
        return "Hello Module2"; 
    }
    
}