package books.spring.security.in.action.app.web.simple.controller;

import books.spring.security.in.action.app.web.simple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Autowired
    private ProductService productService;

    @GetMapping( "/main" )
    public String renderMain(Authentication authentication, Model model ) {
        model.addAttribute( "username", authentication.getName() );
        model.addAttribute( "products", productService.findAll() );

        return "main.html";
    }

}
