package ru.geekbrains.springshop.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.springshop.models.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Long price;
    private Promo promoID;
    private List<Comment> comment;
    private List<Category> categories;
    private List<ProductItem> productItems;
    private Storage storage;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.promoID = product.getPromoID();
        this.comment = product.getComment();
        this.categories = product.getCategories();
        this.productItems = product.getProductItems();
        this.storage = product.getStorage();
    }

    public Product convertToProduct(){
        Product product = new Product();
             product.setId(this.id);
             product.setName(this.name);
             product.setPrice(this.price);
             product.setPromoID(this.promoID);
             product.setComment(this.comment);
             product.setCategories(this.categories);
             product.setProductItems(this.productItems);
             product.setStorage(this.storage);
        return product;
    }

}
