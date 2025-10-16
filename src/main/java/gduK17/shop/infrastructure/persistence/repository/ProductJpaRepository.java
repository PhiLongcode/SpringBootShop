package gduK17.shop.infrastructure.persistence.repository;

import gduK17.shop.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for ProductEntity.
 * This is in the infrastructure layer and provides database access.
 */
@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    // Spring Data JPA will implement basic CRUD operations
    // Add custom query methods here if needed
}