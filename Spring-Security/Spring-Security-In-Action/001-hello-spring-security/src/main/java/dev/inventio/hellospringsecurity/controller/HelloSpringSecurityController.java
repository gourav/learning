package dev.inventio.hellospringsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloSpringSecurityController {

    public static final Logger LOGGER = LoggerFactory.getLogger( HelloSpringSecurityController.class );

    @GetMapping( "/hey" )
    public String sayHello( Principal principal ) {
        return String.format( "Hey %s", principal.getName() );
    }

}
