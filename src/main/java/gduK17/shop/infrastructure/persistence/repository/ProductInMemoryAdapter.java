package gduK17.shop.infrastructure.persistence.repository;

import gduK17.shop.domain.entity.Product;
import gduK17.shop.domain.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * In-memory implementation of ProductRepository.
 * This is useful for testing or as a simple implementation before database
 * setup.
 */
@Component
@Profile("memory")
public class ProductInMemoryAdapter implements ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ProductInMemoryAdapter() {
        // Add some sample data
        saveProduct(new Product("TV", "Smart TV 55 inch", 10000.0, 5, ""));
        saveProduct(new Product("Laptop", "Gaming Laptop", 15000.0, 3, ""));
        saveProduct(new Product("Phone", "Smartphone", 5000.0, 10, ""));
    }

    private Product saveProduct(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter.getAndIncrement());
        }
        productMap.put(product.getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public Product save(Product product) {
        return saveProduct(product);
    }

    @Override
    public void deleteById(Long id) {
        productMap.remove(id);
    }

    @Override
    public void delete(Product product) {
        if (product.getId() != null) {
            productMap.remove(product.getId());
        }
    }

    @Override
    public boolean existsById(Long id) {
        return productMap.containsKey(id);
    }
}