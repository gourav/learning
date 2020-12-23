package books.spring.security.in.action.app.web.simple.service;

import books.spring.security.in.action.app.web.simple.domain.ApplicationUser;
import books.spring.security.in.action.app.web.simple.entities.User;
import books.spring.security.in.action.app.web.simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Supplier<UsernameNotFoundException> exceptionSupplier = () -> new UsernameNotFoundException( String.format( "User not found withh username %s", username ));
        User retrievedUserFromDatabase = userRepository.findUserByUsername( username )
                .orElseThrow( exceptionSupplier );

        return new ApplicationUser( retrievedUserFromDatabase );

    }
}
