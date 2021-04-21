package ru.geekbrains.springshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springshop.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
