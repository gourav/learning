package com.learning.cloud.taco.controller;

import com.learning.cloud.taco.domain.Order;
import com.learning.cloud.taco.repository.impl.jpa.SmartOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping( "/orders" )
@SessionAttributes( "order" )
public class OrderController {

    private final SmartOrderRepository orders;

    @Autowired
    OrderController( SmartOrderRepository orders ) {
        this.orders = orders;
    }

    @GetMapping( "/current" )
    public String orderForm( Model model ) {
        return "orderForm";

    }

    @PostMapping
    public String processOrder( @Valid Order order, Errors allErrors, SessionStatus sessionStatus ) {

        if( allErrors.hasErrors() ) {
            return "orderForm";
        }

        log.info( "Order submitted : " + order );
        this.orders.save( order );
        sessionStatus.setComplete();

        return "redirect:/";

    }
}
