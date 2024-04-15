package com.example.demo.bootstrap;

import com.example.demo.dao.CustomersRepository;
import com.example.demo.dao.DivisionsRepository;
import com.example.demo.entities.Customers;
import com.example.demo.entities.Divisions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private CustomersRepository customersRepository;

    private DivisionsRepository divisionsRepository;

    public BootStrapData(CustomersRepository customersRepository, DivisionsRepository divisionsRepository) {
        this.customersRepository = customersRepository;
        this.divisionsRepository = divisionsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customersRepository.count() == 1) {

            Customers johnny = new Customers("12345 North St.", "Johnny", "Richards", "1234567890", "80324");
            johnny.setDivisions(divisionsRepository.findAll().get(1));
            Customers billy = new Customers("12345 South St.", "Billy", "Johnson", "2345678901", "12345");
            billy.setDivisions(divisionsRepository.findAll().get(2));
            Customers sally = new Customers("12345 West St.", "Sally", "Anderson", "3456789012", "12495");
            sally.setDivisions(divisionsRepository.findAll().get(3));
            Customers james = new Customers("12345 East St.", "James", "Smith", "4567890123", "18547");
            james.setDivisions(divisionsRepository.findAll().get(4));
            Customers jessica = new Customers("12345 Northwest St.", "Jessica", "Jones", "5678901234", "80341");
            jessica.setDivisions(divisionsRepository.findAll().get(5));

            customersRepository.save(johnny);
            customersRepository.save(billy);
            customersRepository.save(sally);
            customersRepository.save(james);
            customersRepository.save(jessica);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of customers: " + customersRepository.count());
        }
    }
}
