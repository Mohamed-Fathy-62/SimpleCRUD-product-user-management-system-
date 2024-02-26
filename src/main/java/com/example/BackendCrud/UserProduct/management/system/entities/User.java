package com.example.BackendCrud.UserProduct.management.system.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "findUserById"
                , query = "SELECT u FROM User u WHERE u.id = :id"
        ),
        @NamedQuery(
                name = "findUserByUsername"
                , query = "SELECT u FROM User u WHERE u.name = :username"
        )
}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal credit;
    private String email;
    //inverse side of relationship mapped by is a must
    @OneToMany(mappedBy = "user")
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", email='" + email + '\'' +
                '}';
    }
}
