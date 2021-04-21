package ru.geekbrains.springshop.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "orderID")
    private List<ProductItem> productItems;

    @Column(name = "price")
    private Long price;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "orderID")
    private List<OrderStatus> orderStatus;



}
