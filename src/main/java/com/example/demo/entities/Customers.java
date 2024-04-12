package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", insertable = false, updatable = false)
    private Long id;

    @NonNull
    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @NonNull
    @Column(name = "customer_first_name")
    private String firstName;

    @NonNull
    @Column(name = "customer_last_name")
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    @NonNull
    @Column(name = "phone")
    private String phone;

    @NonNull
    @Column(name = "postal_code")
    private String postal_code;

    @ManyToOne
    @JoinColumn(name = "division_id", insertable = false, updatable = false)
    private Divisions divisions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Carts> cartsSet;

    public void add(Carts carts) {
        if (cartsSet == null) {
            cartsSet = new HashSet<>();
        }
        cartsSet.add(carts);
        carts.setCustomers(this);
    }
}
