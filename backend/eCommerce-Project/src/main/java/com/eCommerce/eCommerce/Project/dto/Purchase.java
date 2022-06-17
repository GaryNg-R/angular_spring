package com.eCommerce.eCommerce.Project.dto;

import com.eCommerce.eCommerce.Project.entity.Address;
import com.eCommerce.eCommerce.Project.entity.Customer;
import com.eCommerce.eCommerce.Project.entity.Order;
import com.eCommerce.eCommerce.Project.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
