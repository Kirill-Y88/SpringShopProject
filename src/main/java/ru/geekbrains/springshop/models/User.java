package ru.geekbrains.springshop.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "cash_id")
    private Cashback cashID;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role roleID;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
