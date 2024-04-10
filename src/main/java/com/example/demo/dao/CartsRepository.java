package com.example.demo.dao;

import com.example.demo.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "carts", path = "carts")
public interface CartsRepository extends JpaRepository<Carts, Long> {
}
