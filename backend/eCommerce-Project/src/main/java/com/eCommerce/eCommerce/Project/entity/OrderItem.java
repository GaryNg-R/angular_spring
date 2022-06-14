package com.eCommerce.eCommerce.Project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_item")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "unite_price")
    private BigDecimal unitePrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_id")
    private Long productID;


}
