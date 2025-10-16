package gduK17.shop.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import gduK17.shop.domain.entity.Product;

/**
 * DTO for creating a new product.
 * Fields like ID will be generated, so they're not included here.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDTO {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String pathImage;

    /**
     * Convert to domain entity
     * 
     * @return Domain Product entity
     */
    public Product toDomain() {
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setQuantity(this.quantity != null ? this.quantity : 0);
        product.setPathImage(this.pathImage);
        return product;
    }
}