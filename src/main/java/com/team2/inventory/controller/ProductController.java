package com.team2.inventory.controller;

import com.team2.inventory.interfacemethods.ProductInterface;
import com.team2.inventory.interfacemethods.UserInterface;
import com.team2.inventory.model.Product;
import com.team2.inventory.service.ProductImplementation;
import com.team2.inventory.service.UserImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
@SessionAttributes("userdetails")
public class ProductController {
    @Autowired
    private ProductInterface pservice;

    @Autowired
    public void setProductService(ProductImplementation pserviceImpl) {
        this.pservice = pserviceImpl;
    }

    @Autowired
    private UserInterface uservice;

    @RequestMapping(value = "/all/product/list")
    public String listProducts(Model model) {
        model.addAttribute("products", pservice.findAllProducts());
        return "products";
    }

    @RequestMapping(value = "/admin/product/add")
    public String addForm(ModelMap model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @RequestMapping(value = "/admin/product/edit/{id}")
    public String editProductForm(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("product", pservice.findProductById(id));
        return "product-form";
    }

    //save an edited product record 
    @RequestMapping(value = "/admin/product/save")
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        Product dbProduct = pservice.findProductById(product.getId());

        pservice.saveProduct(product);

        return "forward:/all/product/list";
    }

    //method to save a newly created product
    @RequestMapping(value = "/admin/product/savenew")
    public String saveNewProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            return "product-form";
        }

        pservice.saveProduct(product);

        return "forward:/all/product/list";
    }

    //method to delete a product
    @RequestMapping(value = "/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        Product product = pservice.findProductById(id);

        pservice.deleteProduct(product);

        return "forward:/all/product/list";
    }
}