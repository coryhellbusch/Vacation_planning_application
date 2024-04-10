package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter
public class Excursions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "excursion_price")
    private Double excursion_price;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

//    @Column(name = "vacation_id")
//    private Long vacationId;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private CartItems cartItems;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacations vacations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartItemId")
    private Set<CartItems> cartItemsSet;
}
