package com.quicksilvarad.jmeterTest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    private String customerName;
    private String lastName;
    private String email;
    private String address;
    private String itemQty;
    @CreationTimestamp
    private Timestamp createdTs;

}
