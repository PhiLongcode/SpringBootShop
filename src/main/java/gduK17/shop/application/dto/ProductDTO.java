package gduK17.shop.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import gduK17.shop.domain.entity.Product;

/**
 * Data Transfer Object for Product entity.
 * Used for transferring product data between layers, especially to/from the
 * presentation layer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String pathImage;

    /**
     * Convert from domain entity to DTO
     * 
     * @param product Domain Product entity
     * @return ProductDTO
     */
    public static ProductDTO fromDomain(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .pathImage(product.getPathImage())
                .build();
    }

    /**
     * Convert from DTO to domain entity
     * 
     * @return Domain Product entity
     */
    public Product toDomain() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setQuantity(this.quantity != null ? this.quantity : 0);
        product.setPathImage(this.pathImage);
        return product;
    }
}