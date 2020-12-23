package books.spring.security.in.action.app.web.simple.repository;

import books.spring.security.in.action.app.web.simple.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername( String username );

}
