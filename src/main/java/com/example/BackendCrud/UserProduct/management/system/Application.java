package com.example.BackendCrud.UserProduct.management.system;

import com.example.BackendCrud.UserProduct.management.system.entities.Category;
import com.example.BackendCrud.UserProduct.management.system.entities.Product;
import com.example.BackendCrud.UserProduct.management.system.entities.User;
import com.example.BackendCrud.UserProduct.management.system.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);



//		em.getTransaction().begin();
//
//		//user
//		User user = new User();
//		user.setName("Mohamed Fathy");
//		user.setCredit(BigDecimal.valueOf(99999.526));
//		user.setEmail("mo@example.com");
//
//		//categories
//		Category category1 = new Category();
//		category1.setType("fruits");
//		Category category2 = new Category();
//		category2.setType("vegatables");
//		//product1
//		Product p1 = new Product();
//		p1.setName("Apple");
//		p1.setCategory(category1);
//		p1.setPrice(BigDecimal.valueOf(10.2));
//		p1.setExpDate(new Date());
//		p1.setUser(user);
//		//product2
//		Product p2 = new Product();
//		p2.setName("Onion");
//		p2.setCategory(category2);
//		p2.setPrice(BigDecimal.valueOf(6.7));
//		p2.setExpDate(new Date());
//		p2.setUser(user);
//		//one to many
//		category1.setProducts(List.of(p1));
//		category2.setProducts(List.of(p2));
//		user.setProducts(List.of(p1,p2));
//
//		em.persist(user);
//		em.persist(category1);
//		em.persist(category2);
//		em.persist(p1);
//		em.persist(p2);
//
//
//		em.getTransaction().commit();
//		em.close();

	}

}
