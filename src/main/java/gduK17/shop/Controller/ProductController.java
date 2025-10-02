package gduK17.shop.Controller;

import gduK17.shop.Model.Product;
import gduK17.shop.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*@RestController ("api")*/
/*@Service*/
@Controller
@RequestMapping("/products")
public class ProductController {
 /*   @GetMapping("/product/list")
    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        ProductService productService = new ProductService();
        list = productService.getProducts();
        return list;
    }*/

  /*  public ProductController(ProductService productService) {
        this.productService = productService;
    }*/

    /*  @GetMapping("/")
        public List<Product> findAll(){
            List<Product> list = new ArrayList<>();
            ProductService productService = new ProductService();
            list = productService.getProducts();
            return list;
        }*/
// view
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products/list"; // -> src/main/resources/templates/products/list.html
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("products", new Product());
        return "products/add";
    }
    @PostMapping("/add")
    public String addProduct(Product product) {

        productService.saveProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id,@ModelAttribute Product product) {
        product.setId(id);
        productService.saveProduct(product); // save lại (overwrite nếu id trùng)
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id,@ModelAttribute Product product) {
        product.setId(id);
        productService.deleteProduct(product);
        return "redirect:/products/list";
    }

}
