package ru.geekbrains.springshop.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springshop.models.Order;
import ru.geekbrains.springshop.models.OrderStatus;
import ru.geekbrains.springshop.models.ProductItem;
import ru.geekbrains.springshop.models.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private User user;
    private List<ProductItem> productItems;
    private Long price;
    private LocalDateTime createDate;
    private List<OrderStatus> orderStatus;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.productItems = order.getProductItems();
        this.price = order.getPrice();
        this.createDate = order.getCreateDate();
        this.orderStatus = order.getOrderStatus();
    }

    public Order convertToOrder(){
        Order order = new Order();
        order.setId(this.id);
        order.setUser(this.user);
        order.setProductItems(this.productItems);
        order.setPrice(this.price);
        order.setCreateDate(this.createDate);
        order.setOrderStatus(this.orderStatus);
        return order;
    }
}
