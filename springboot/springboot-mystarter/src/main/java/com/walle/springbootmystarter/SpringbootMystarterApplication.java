package com.walle.springbootmystarter;

import com.example.autocinfigure.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.example.autocinfigure")
public class SpringbootMystarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMystarterApplication.class, args);
    }
    @Autowired
    private ExampleService exampleService;

    @GetMapping("/input/{word}")
    public String input(@PathVariable String word){
        return exampleService.wrap(word);
    }
}
