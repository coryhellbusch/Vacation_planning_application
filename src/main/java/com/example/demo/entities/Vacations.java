package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "vacation_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "vacation_title")
    private String vacation_title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacations")
    private Set<Excursions> excursions;

}
