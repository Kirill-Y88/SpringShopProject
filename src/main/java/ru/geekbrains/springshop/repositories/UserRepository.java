package ru.geekbrains.springshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springshop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
