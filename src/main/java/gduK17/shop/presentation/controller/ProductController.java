package gduK17.shop.presentation.controller;

import gduK17.shop.application.dto.ProductDTO;
import gduK17.shop.domain.entity.Product;
import gduK17.shop.domain.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for Product operations following Clean Architecture principles.
 * This controller is part of the presentation layer and uses the domain service
 * through dependency injection.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/list", "/"})
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductDTO::fromDomain)
                .collect(Collectors.toList());

        model.addAttribute("products", productDTOs);
        return "products/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("products", new ProductDTO());
        return "products/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO productDTO, RedirectAttributes redirectAttributes,
            @RequestParam("imageFile") MultipartFile file) {
        try {
            // Convert DTO to domain entity
            Product product = productDTO.toDomain();

            // Handle file upload
            if (!file.isEmpty()) {
                String uploadDir = "public/uploads/";
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);

                Files.createDirectories(path.getParent());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                product.setPathImage("/uploads/" + fileName);
            }

            // Save product using service
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "error: " + e.getMessage());
        }

        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        productService.getProductById(id)
                .map(ProductDTO::fromDomain)
                .ifPresent(productDTO -> model.addAttribute("product", productDTO));
        return "products/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute ProductDTO productDTO,
            @RequestParam(value = "imageFile", required = false) MultipartFile file,
            RedirectAttributes redirectAttributes) {
        try {
            // Convert DTO to domain entity
            Product product = productDTO.toDomain();
            product.setId(id);

            // Handle file upload if provided
            if (file != null && !file.isEmpty()) {
                String uploadDir = "public/uploads/";
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);

                Files.createDirectories(path.getParent());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                product.setPathImage("/uploads/" + fileName);
            }

            // Save updated product
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật sản phẩm thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "error: " + e.getMessage());
        }

        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable Long id, Model model) {
        productService.getProductById(id)
                .map(ProductDTO::fromDomain)
                .ifPresent(productDTO -> model.addAttribute("product", productDTO));
        return "products/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteProductById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa sản phẩm thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "error: " + e.getMessage());
        }
        return "redirect:/products/list";
    }
}