package gduK17.shop.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA Entity for Product.
 * This is the infrastructure layer's representation of a Product, mapped to the
 * database.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column
    private String pathImage;

    /**
     * Convert to domain entity
     * 
     * @return Domain Product entity
     */
    public gduK17.shop.domain.entity.Product toDomain() {
        gduK17.shop.domain.entity.Product product = new gduK17.shop.domain.entity.Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setQuantity(this.quantity != null ? this.quantity : 0);
        product.setPathImage(this.pathImage);
        return product;
    }

    /**
     * Create from domain entity
     * 
     * @param product Domain Product entity
     * @return ProductEntity
     */
    public static ProductEntity fromDomain(gduK17.shop.domain.entity.Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .pathImage(product.getPathImage())
                .build();
    }
}