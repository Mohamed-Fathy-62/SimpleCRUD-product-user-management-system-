package com.example.BackendCrud.UserProduct.management.system.controllers;

import com.example.BackendCrud.UserProduct.management.system.entities.Product;
import com.example.BackendCrud.UserProduct.management.system.entities.User;
import com.example.BackendCrud.UserProduct.management.system.services.MailingService;
import com.example.BackendCrud.UserProduct.management.system.services.ProductService;
import com.example.BackendCrud.UserProduct.management.system.services.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    final private MailingService mailingService;
    final private ProductService productService;
    final private UserService userService;

    //trying to think of better way
    final private EntityManager entityManager;

    public ProductController(MailingService mailingService, ProductService productService, UserService userService, EntityManager entityManager) {
        this.mailingService = mailingService;
        this.productService = productService;
        this.userService = userService;
        this.entityManager = entityManager;
    }

    @GetMapping("/products/all")
    @ResponseBody
    public Map<String, String> printAll(){
        Map<String, String> mp = new HashMap<>();
        List<Product> productList = productService.findListOfProducts();
        for(int i = 0; i < productList.size(); i++){
            mp.put("product"+(i), productList.get(i).toString());
        }

        return mp;
    }
    //endpoint to buy a product for user by using productid and userid
    //suppose user have enough credit
    @GetMapping("/products/buy/uid={userid}/pid={productid}")
    public void buyProduct(@PathVariable String userid,
                           @PathVariable String productid
    ){
        User user = userService.findUserById(userid);
        Product product = productService.findProductById(productid);
        entityManager.getTransaction().begin();

        //merging into hibernate context rather than execute update sql manually
        entityManager.merge(product);
        entityManager.merge(user);
        BigDecimal currentCredit = user.getCredit().subtract(product.getPrice());
        user.setCredit(currentCredit);

        entityManager.getTransaction().commit();
        entityManager.close();
        MailingService.sendTransactionEmail(product, user);
    }
}
