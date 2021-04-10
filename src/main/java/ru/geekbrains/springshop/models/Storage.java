package ru.geekbrains.springshop.models;


import javax.persistence.*;

@Entity
@Table(name = "product_items")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItemID;

    @Column(name = "amount")
    private Long amount;

    public Storage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductItem getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(ProductItem productItemID) {
        this.productItemID = productItemID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
