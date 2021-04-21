package ru.geekbrains.springshop.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springshop.models.Cashback;
import ru.geekbrains.springshop.models.Order;
import ru.geekbrains.springshop.models.Role;
import ru.geekbrains.springshop.models.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private Cashback cashID;
    private Role roleID;
    private List<Order> orders;

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.cashID = user.getCashID();
        this.roleID = user.getRoleID();
        this.orders = user.getOrders();
    }

    public User convertToUser(){
        User user = new User();
            user.setId(this.getId());
            user.setLogin(this.getLogin());
            user.setPassword(this.getPassword());
            user.setCashID(this.getCashID());
            user.setRoleID(this.getRoleID());
            user.setOrders(this.getOrders());
        return user;
    }

}
