package com.example.demo.services;

import com.example.demo.dao.CartsRepository;
import com.example.demo.dao.CustomersRepository;
import com.example.demo.entities.CartItems;
import com.example.demo.entities.Carts;
import com.example.demo.entities.Customers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;
import java.util.UUID;

@Service
@CrossOrigin("http://localhost:4200")
public class CheckoutServiceImpl implements CheckoutService {

    private CustomersRepository customersRepository;
    private CartsRepository cartsRepository;

    @Autowired
    public CheckoutServiceImpl(CustomersRepository customersRepository, CartsRepository cartsRepository) {
        this.customersRepository = customersRepository;
        this.cartsRepository = cartsRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Carts carts = purchase.getCart();
        System.out.println(purchase);

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        carts.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cartsItems
        Set<CartItems> cartItemsSet = purchase.getCartItems();
        cartItemsSet.forEach(carts::add);

        carts.setCustomers(purchase.getCustomer());
        carts.setCartItemsSet(purchase.getCartItems());

        // populate customer with cart
        Customers customers = purchase.getCustomer();
        customers.add(carts);

        carts.setStatus(Carts.Status.ordered);

        // save to the database
        customersRepository.save(customers);
//        cartsRepository.save(carts);

        // return a response
        if (purchase.getCartItems() == null) {
            return new PurchaseResponse("Cart is empty.");
        }
        else {
            return new PurchaseResponse(orderTrackingNumber);
        }

    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();

    }
}
