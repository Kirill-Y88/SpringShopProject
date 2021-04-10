package ru.geekbrains.springshop.models;


import javax.persistence.*;

@Entity
@Table(name = "promo")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;

    @Column(name = "promo")
    private Long promo;


    public Promo() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public Long getPromo() {
        return promo;
    }

    public void setPromo(Long promo) {
        this.promo = promo;
    }
}
