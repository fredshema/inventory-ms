package com.team2.inventory.interfacemethods;

import com.team2.inventory.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductInterface {
    public boolean saveProduct(Product product);
    public List<Product> findAllProducts();
    public Product findProductById(Integer id);
    public void deleteProduct(Product product);
    public Page<Product> findAllProduts(int pageNumber, String sortField, String sortDir);
}
