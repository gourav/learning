package books.spring.security.in.action.app.web.simple.service;

import books.spring.security.in.action.app.web.simple.entities.Product;
import books.spring.security.in.action.app.web.simple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
