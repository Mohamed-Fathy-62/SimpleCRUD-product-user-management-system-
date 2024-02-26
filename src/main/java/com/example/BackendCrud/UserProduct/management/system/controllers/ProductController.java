package com.example.BackendCrud.UserProduct.management.system.controllers;

import com.example.BackendCrud.UserProduct.management.system.entities.Product;
import com.example.BackendCrud.UserProduct.management.system.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {


    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/all")
    @ResponseBody
    public Map<String, String> printAll(){
        Map<String, String> mp = new HashMap<>();
        List<Product> productList = productService.getListOfProducts();
        for(int i = 0; i < productList.size(); i++){
            mp.put("product"+(i), productList.get(i).toString());
        }

        return mp;
    }
    /*@GetMapping("/products/buy/uid{userid}/pid{productid}")
    public void buyProduct(){

    }*/
}
