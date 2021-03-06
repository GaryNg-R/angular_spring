package com.eCommerce.eCommerce.Project.service;

import com.eCommerce.eCommerce.Project.dao.CustomerRepository;
import com.eCommerce.eCommerce.Project.dto.Purchase;
import com.eCommerce.eCommerce.Project.dto.PurchaseResponse;
import com.eCommerce.eCommerce.Project.entity.Customer;
import com.eCommerce.eCommerce.Project.entity.Order;
import com.eCommerce.eCommerce.Project.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServicelmpl implements CheckoutService{

    private CustomerRepository customerRepository;

    //Autowired is optional since we only have one constructor
    //@Autowired
    public CheckoutServicelmpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        Set<OrderItem> orderItems  = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer = purchase.getCustomer();

        //check if this is an existing customer
        String theEmail = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(theEmail);
        if(customerFromDB != null){
            //We found them ... let's assign them accordingly
            customer = customerFromDB;
        }
        customer.add(order);
        //save to the database
        customerRepository.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
