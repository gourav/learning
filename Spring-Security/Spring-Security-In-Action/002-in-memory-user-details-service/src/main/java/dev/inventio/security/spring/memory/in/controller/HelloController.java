package dev.inventio.security.spring.memory.in.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping( "hey" )
    public String sayHey( Principal principal) {
        return String.format( "Hey %s !", principal.getName() );
    }


}
