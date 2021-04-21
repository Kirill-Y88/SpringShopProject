package ru.geekbrains.springshop.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promo promoID;

    @OneToMany(mappedBy = "productID")
    private List<Comment> comment;

    @ManyToMany
    @JoinTable(
           name = "product_category",
           joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany(mappedBy = "productID")
    private List <ProductItem> productItems;

    @OneToOne(mappedBy = "productID")
    private Storage storage;



}
