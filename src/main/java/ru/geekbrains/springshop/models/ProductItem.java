package ru.geekbrains.springshop.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_items")
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;

    @Column(name = "serial_number")
    private Long serialNumber;

    public ProductItem() {
    }

    @OneToOne(mappedBy = "productItemID")
    private Storage storage;

    @OneToOne(mappedBy = "productItemID")
    private Order order;


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

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
