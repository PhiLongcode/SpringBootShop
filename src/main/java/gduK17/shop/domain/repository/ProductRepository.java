package gduK17.shop.domain.repository;

import gduK17.shop.domain.entity.Product;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Product domain entity.
 * This interface defines the contract for data access operations on Product
 * entities.
 * By defining it in the domain layer, we ensure that the domain doesn't depend
 * on
 * infrastructure concerns (DIP principle).
 */
public interface ProductRepository {

    /**
     * Find all products
     * 
     * @return List of all products
     */
    List<Product> findAll();

    /**
     * Find a product by its ID
     * 
     * @param id the product ID
     * @return Optional containing the product if found, empty otherwise
     */
    Optional<Product> findById(Long id);

    /**
     * Save a product (create or update)
     * 
     * @param product the product to save
     * @return the saved product with its ID (if new)
     */
    Product save(Product product);

    /**
     * Delete a product by ID
     * 
     * @param id the product ID to delete
     */
    void deleteById(Long id);

    /**
     * Delete a product
     * 
     * @param product the product to delete
     */
    void delete(Product product);

    /**
     * Check if a product with the given ID exists
     * 
     * @param id the product ID
     * @return true if the product exists, false otherwise
     */
    boolean existsById(Long id);
}