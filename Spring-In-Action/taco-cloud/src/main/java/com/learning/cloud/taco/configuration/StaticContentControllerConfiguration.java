package com.learning.cloud.taco.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class will allow us to establish mappings for Controllers that don't require any logic besides rendering via
 * a template.
 */
@Configuration
public class StaticContentControllerConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {

        /*
         * This configures that all requests on / should be handled via "home.html" layout.
         */
        registry.addViewController( "/" ).setViewName( "home" );
    }
}
