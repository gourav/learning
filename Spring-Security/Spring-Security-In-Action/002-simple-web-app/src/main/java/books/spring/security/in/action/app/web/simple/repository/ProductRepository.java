package books.spring.security.in.action.app.web.simple.repository;

import books.spring.security.in.action.app.web.simple.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
