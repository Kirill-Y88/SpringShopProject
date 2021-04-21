package ru.geekbrains.springshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springshop.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
