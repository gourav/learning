package books.spring.security.in.action.app.web.simple.provider;

import books.spring.security.in.action.app.web.simple.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService jpaUserDetailsService;

    @Autowired
    private PasswordEncoder bcryptPasswordEncoder;

    @Autowired
    private PasswordEncoder scryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = jpaUserDetailsService.loadUserByUsername(username);

        if (user instanceof ApplicationUser) {

            ApplicationUser applicationUser = (ApplicationUser) user;
            switch ( applicationUser.getUser().getAlgorithm() ) {

                case BCRYPT:
                    return checkPassword( applicationUser, password, bcryptPasswordEncoder );

                case SCRYPT:
                    return checkPassword( applicationUser, password, scryptPasswordEncoder );

            }

        }

        throw new BadCredentialsException( "Bad Credentials" );

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private Authentication checkPassword( ApplicationUser user, String password, PasswordEncoder encoder ) {

        if( encoder.matches( password, user.getPassword() )) {
            return new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities()
            );
        } else {
            throw new BadCredentialsException( "Bad Credentials" );
        }

    }
}
