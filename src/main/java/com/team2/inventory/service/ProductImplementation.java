package com.team2.inventory.service;

import com.team2.inventory.interfacemethods.ProductInterface;
import com.team2.inventory.model.Product;
import com.team2.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductImplementation implements ProductInterface {
    @Autowired
    ProductRepository prepo;

    @Override
    @Transactional
    public boolean saveProduct(Product product) {
        if (prepo.save(product) != null)
            return true;
        else
            return false;
    }

    @Transactional
    public Page<Product> findAllProduts(int pageNumber, String sortField, String sortDir) {
        Sort sort=Sort.by(sortField);
        sort=sortDir.equals("asc")?sort.ascending():sort.descending();
        Pageable pageable= PageRequest.of(pageNumber - 1, 5,sort);
        return prepo.findAll(pageable);
    }


    @Override
    @Transactional
    public List<Product> findAllProducts() {
        return prepo.findAll();
    }

    @Override
    @Transactional
    public Product findProductById(Integer id) {
        return prepo.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        prepo.delete(product);
    }
}