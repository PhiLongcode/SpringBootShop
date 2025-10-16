package gduK17.shop.domain.entity;

/**
 * Domain entity for Product.
 * This is pure domain class, independent of any persistence framework.
 */
public class Product extends Entity {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;

    @Override
    public boolean isEmpty() {
        return id == null && (name == null || name.trim().isEmpty())
                && (description == null || description.trim().isEmpty())
                && (price == null || price <= 0)
                && quantity <= 0;
    }
    private String pathImage;

    // Constructor without ID for creating new products
    public Product(String name, String description, Double price, int quantity, String pathImage) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.pathImage = pathImage;
    }

    // Constructor with ID for reconstructing existing products
    public Product(Long id, String name, String description, Double price, int quantity, String pathImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.pathImage = pathImage;
    }

    // No-args constructor
    public Product() {
    }

    // Domain business logic methods can be added here
    public void decreaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this.quantity) {
            throw new IllegalStateException("Not enough items in stock");
        }
        this.quantity -= amount;
    }

    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.quantity += amount;
    }

    public boolean isAvailable() {
        return this.quantity > 0;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price != null && price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}