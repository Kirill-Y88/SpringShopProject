package ru.geekbrains.springshop.models;


import javax.persistence.*;

@Entity
@Table(name = "cashback")
public class Cashback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name = "cash")
    private Long cash;

    public Cashback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }
}
