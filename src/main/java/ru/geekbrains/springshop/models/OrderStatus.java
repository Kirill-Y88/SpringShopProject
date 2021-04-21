package ru.geekbrains.springshop.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "data")
    private String data;

    @Column(name = "create_date")
    private LocalDateTime createDate;


}
