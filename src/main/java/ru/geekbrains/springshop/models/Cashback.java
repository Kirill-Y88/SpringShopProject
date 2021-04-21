package ru.geekbrains.springshop.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "cashback")
public class Cashback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cash")
    private Long cash;

    @OneToOne(mappedBy = "cashID")
    private User user;



}
