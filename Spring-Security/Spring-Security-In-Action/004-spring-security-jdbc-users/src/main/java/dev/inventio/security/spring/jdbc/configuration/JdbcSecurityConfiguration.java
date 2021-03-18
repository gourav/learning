package dev.inventio.security.spring.jdbc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class JdbcSecurityConfiguration {

    private DataSource dataSource;

    public JdbcSecurityConfiguration( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService() {

        JdbcUserDetailsManager manager = new JdbcUserDetailsManager( dataSource );

        UserDetails john = User.withUsername( "john" )
                .password( "12345" )
                .passwordEncoder( password -> encoder().encode( password ))
                .authorities( "READ" )
                .build();

        manager.createUser( john );

        return manager;

    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
