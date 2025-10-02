package gduK17.shop.Service;


import gduK17.shop.Model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class ProductService {

    // tạo giả lập dữ liệu in-memory
    private  final Map<Long, Product> productMap=new HashMap<>();
// tự động tạo id
    private final AtomicLong id=new AtomicLong(1);

    public ProductService(){
        this.saveProduct(new Product("TV", "pr1",10000.0,5));
        this.saveProduct(new Product("TV2", "pr2",10000.0,5));
        this.saveProduct(new Product("TV3", "pr3",10000.0,5));

    }
public List<Product> getProducts(){
        List<Product> products=new ArrayList<>(productMap.values());
        products.sort(Comparator.comparing(Product::getId));
        return  new ArrayList<>(productMap.values());
}
    public Product getProductById(long id){
        return productMap.get(id);
    }
    public Product saveProduct(Product product){
        if(product.getId()==null){
            product.setId(id.getAndIncrement());
        }

        productMap.put(product.getId(), product);
        return product;
    }
    public Product deleteProduct(Product product){
        if(product.getId()==null){
            product.setId(id.getAndIncrement());
        }

        productMap.remove(product.getId(), product);
        return product;
    }
}
