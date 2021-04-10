package ru.geekbrains.springshop.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItemID;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @OneToMany
    @JoinColumn(name = "orderID")
    private List<OrderStatus> orderStatus;


    public Order() {
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public List<OrderStatus> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<OrderStatus> orderStatus) {
        this.orderStatus = orderStatus;
    }
}
