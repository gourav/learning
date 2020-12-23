package books.spring.security.in.action.app.web.simple.configuration;

import books.spring.security.in.action.app.web.simple.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsernamePasswordAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider( authenticationProvider );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers( "/h2/**" ).permitAll()
                .and().csrf().ignoringAntMatchers( "/h2/**" )
                .and().headers().frameOptions().sameOrigin();

        http.formLogin()
                .defaultSuccessUrl( "/main", true );

        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}
