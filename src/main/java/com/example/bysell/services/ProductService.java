package com.example.bysell.services;


import com.example.bysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PS5", "Simple description", 67000, "Ufa", "chel"));
        products.add(new Product(++ID, "Drone", "Simple description", 45000, "Moscow", "chelik"));
        products.add(new Product(++ID, "Table", "Simple description", 2000, "Dubna", "chelovek"));
    }

    public List<Product> listProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for(Product product : products){
            if(product.getId().equals(id)) return product;
        }
        return null;
    }
}
