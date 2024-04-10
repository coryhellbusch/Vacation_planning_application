package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long cartItemId;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

//    @Column(name = "cart_id")
//    private Long cartId;

    @Column(name = "vacation_id")
    private Long vacation;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts carts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<Excursions> excursionsSet;

}
