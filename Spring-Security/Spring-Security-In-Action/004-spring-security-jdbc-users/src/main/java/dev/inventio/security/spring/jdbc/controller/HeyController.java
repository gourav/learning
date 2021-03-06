package dev.inventio.security.spring.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HeyController {

    @GetMapping( "/hey" )
    public String sayHello( Principal principal ) {
        return String.format( "Hello %s !", principal.getName() );
    }

}
