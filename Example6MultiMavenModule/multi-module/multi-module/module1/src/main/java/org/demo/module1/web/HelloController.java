package org.demo.module1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController 
public class HelloController {

    @GetMapping
    public String module1(){
        return "Hello Module 1"; 
    }
    
}