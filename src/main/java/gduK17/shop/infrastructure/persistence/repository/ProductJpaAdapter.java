package gduK17.shop.infrastructure.persistence.repository;

import gduK17.shop.domain.entity.Product;
import gduK17.shop.domain.repository.ProductRepository;
import gduK17.shop.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * JPA implementation of the ProductRepository interface.
 * This adapter connects the domain layer to the JPA infrastructure.
 */
@Component
public class ProductJpaAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductJpaAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll()
                .stream()
                .map(ProductEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(ProductEntity::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntity.fromDomain(product);
        ProductEntity savedEntity = productJpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        productJpaRepository.deleteById(product.getId());
    }

    @Override
    public boolean existsById(Long id) {
        return productJpaRepository.existsById(id);
    }
}