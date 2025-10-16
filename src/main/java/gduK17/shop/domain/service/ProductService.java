package gduK17.shop.domain.service;

import gduK17.shop.domain.entity.Product;
import java.util.List;
import java.util.Optional;

/**
 * Product service interface that defines use cases for product operations.
 * This is part of the domain layer and independent of infrastructure concerns.
 */
public interface ProductService {

    /**
     * Get all products
     * 
     * @return List of all products
     */
    List<Product> getAllProducts();

    /**
     * Get a product by ID
     * 
     * @param id The product ID
     * @return Optional containing the product if found, empty otherwise
     */
    Optional<Product> getProductById(Long id);

    /**
     * Save a product (create or update)
     * 
     * @param product The product to save
     * @return The saved product with ID (if new)
     */
    Product saveProduct(Product product);

    /**
     * Delete a product
     * 
     * @param product The product to delete
     */
    void deleteProduct(Product product);

    /**
     * Delete a product by ID
     * 
     * @param id The product ID to delete
     */
    void deleteProductById(Long id);

    /**
     * Update product stock
     * 
     * @param productId      The product ID
     * @param quantityChange The quantity change (positive for increase, negative
     *                       for decrease)
     * @return The updated product
     */
    Product updateProductStock(Long productId, int quantityChange);
}