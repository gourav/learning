package books.spring.security.in.action.app.web.simple.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * CredentialEncoderConfiguration configures different encoders that this application is going to
 * utilize.
 */
@Configuration
public class CredentialEncoderConfiguration {

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean PasswordEncoder scryptPasswordEncoder() {
        return new SCryptPasswordEncoder();
    }
}
