package ru.geekbrains.springshop.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    public User() {
    }

    @OneToOne(mappedBy = "userID")
    private Comment comment;

    @OneToOne(mappedBy = "userID")
    private Cashback cashback;

    @OneToOne(mappedBy = "userID")
    private Order order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Cashback getCashback() {
        return cashback;
    }

    public void setCashback(Cashback cashback) {
        this.cashback = cashback;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
