package ru.geekbrains.springshop.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springshop.dto.OrderDto;
import ru.geekbrains.springshop.dto.ProductDto;
import ru.geekbrains.springshop.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> findAll(){
        List<ProductDto> productDtos = null;
        productDtos = (productRepository.findAll().stream().map(ProductDto::new)).collect(Collectors.toList());
        return productDtos;
    }

    public ProductDto findByID(Long id){
        ProductDto productDto = null;
        productDto = (productRepository.findById(id).map(ProductDto::new)).get();
        return productDto;
    }

}
