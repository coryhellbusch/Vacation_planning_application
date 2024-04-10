package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
        private Double package_price;

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

        @Column(name = "customer_id")
        private Long customer;

        @ManyToOne
        @JoinColumn(name = "customer_id", nullable = false)
        private Customers customers;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart_id")
        private Set<CartItems> cartItemsSet;

        public enum Status {
                PENDING,
                ORDERED,
                CANCELED
        }

}
