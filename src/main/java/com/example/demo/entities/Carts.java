package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Carts {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cart_id")
        private Long id;

        @Column(name = "package_price")
        private BigDecimal package_price;

        @Column(name = "party_size")
        private Integer party_size;

        @Column(name = "status")
        @Enumerated(EnumType.STRING)
        private Status status;

        @Column(name = "order_tracking_number")
        private String orderTrackingNumber;

        @CreationTimestamp
        @Column(name = "create_date")
        private Date createDate;

        @UpdateTimestamp
        @Column(name = "last_update")
        private Date lastUpdate;

//        @Column(name = "customer_id")
//        private Long customer;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private Customers customers;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartItemId")
        private Set<CartItems> cartItemsSet;

        public void add(CartItems item) {
                if (cartItemsSet == null) {
                        cartItemsSet = new HashSet<>();
                }
                cartItemsSet.add(item);
                item.setCarts(this);
        }

        public enum Status {
                pending,
                ordered,
                canceled
        }

}
