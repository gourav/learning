package dev.inventio.security.spring.adapter.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails john = User.withUsername( "john" )
                .password( "12345" )
                .authorities( "READ" )
                .build();

        manager.createUser( john );

        auth.userDetailsService( manager )
                .passwordEncoder( NoOpPasswordEncoder.getInstance() );

    }
}
