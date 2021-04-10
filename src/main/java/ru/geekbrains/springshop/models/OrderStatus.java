package ru.geekbrains.springshop.models;


import javax.persistence.*;

@Entity
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderID;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "data")
    private String data;

    @Column(name = "order_number")
    private String orderNumber;

    public OrderStatus() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
