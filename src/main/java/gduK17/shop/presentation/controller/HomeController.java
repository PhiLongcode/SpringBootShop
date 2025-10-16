package gduK17.shop.presentation.controller;

import gduK17.shop.application.dto.ProductDTO;
import gduK17.shop.domain.entity.Product;
import gduK17.shop.domain.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller for handling the home page and product details.
 */
@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/products"})
    public String home(Model model) {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductDTO::fromDomain)
                .collect(Collectors.toList());

        model.addAttribute("products", productDTOs);
        return "index";
    }

    @GetMapping("/products/detail/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productService.getProductById(id);

        if (productOptional.isPresent()) {
            ProductDTO productDTO = ProductDTO.fromDomain(productOptional.get());
            model.addAttribute("product", productDTO);

            // Get related products (for example, random products or same category)
            List<Product> relatedProductList = productService.getAllProducts().stream()
                    .filter(p -> !p.getId().equals(id))
                    .limit(4) // Limit to 4 related products
                    .collect(Collectors.toList());

            List<ProductDTO> relatedProductDTOs = relatedProductList.stream()
                    .map(ProductDTO::fromDomain)
                    .collect(Collectors.toList());

            model.addAttribute("relatedProducts", relatedProductDTOs);

            return "products/detail";
        } else {
            // Product not found, redirect to product list
            return "redirect:/products";
        }
    }
}