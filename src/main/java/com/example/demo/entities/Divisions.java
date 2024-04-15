package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Divisions {

//    public Divisions() {
//
//    }

//    public Divisions(String division_name, long country_id) {
//        this.division_name = division_name;
//        this.country_id = country_id;
//    }

    @Column(name = "division")
    private String division_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Countries country;

    @Column(name = "country_id")
    private long country_id;
    public void setCountry(Countries country) {
        setCountry_id(country.getId());
        this.country = country;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Customers> customersSet = new HashSet<>();

    public void setCustomers(Customers customers) {
    }
}
