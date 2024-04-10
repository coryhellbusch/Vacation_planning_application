package com.example.demo.dao;

import com.example.demo.entities.Vacations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "vacations", path = "vacations")
public interface VacationsRepository extends JpaRepository<Vacations, Long> {
}
