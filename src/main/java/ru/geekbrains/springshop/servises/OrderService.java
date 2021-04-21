package ru.geekbrains.springshop.servises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springshop.dto.OrderDto;
import ru.geekbrains.springshop.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public List<OrderDto> findAll(){
        List<OrderDto> orderDtos = null;
        orderDtos = (orderRepository.findAll().stream().map(OrderDto::new)).collect(Collectors.toList());
        return orderDtos;
    }

    public OrderDto findByID(Long id){
        OrderDto orderDto = null;
        orderDto = (orderRepository.findById(id).map(OrderDto::new)).get();
        return orderDto;
    }


}
