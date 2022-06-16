package com.eCommerce.eCommerce.Project.service;

import com.eCommerce.eCommerce.Project.dao.CustomerRepository;
import com.eCommerce.eCommerce.Project.dto.Purchase;
import com.eCommerce.eCommerce.Project.dto.PurchaseResponse;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServicelmpl implements CheckoutService{

    private CustomerRepository customerRepository;

    //Autowired is optional since we only have one constructor
    //@Autowired
    public CheckoutServicelmpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        return null;
    }
}
