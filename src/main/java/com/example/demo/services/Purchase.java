package com.example.demo.services;

import com.example.demo.entities.CartItems;
import com.example.demo.entities.Carts;
import com.example.demo.entities.Customers;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Data
@CrossOrigin("http://localhost:4200")
public class Purchase {
    private Customers customer;
    private Carts cart;
    private Set<CartItems> cartItems;

}
