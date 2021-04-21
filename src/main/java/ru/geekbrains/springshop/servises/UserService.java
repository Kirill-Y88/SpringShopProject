package ru.geekbrains.springshop.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springshop.dto.UserDto;
import ru.geekbrains.springshop.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> findAll(){
        List<UserDto> userDtos = null;
        userDtos = (userRepository.findAll().stream().map(UserDto::new)).collect(Collectors.toList());
        return userDtos;
    }

    public UserDto findByID(Long id){
        UserDto userDto = null;
        userDto = (userRepository.findById(id).map(UserDto::new)).get();
        return userDto;
    }

}
