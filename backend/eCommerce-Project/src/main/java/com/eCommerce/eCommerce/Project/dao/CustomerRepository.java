package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //select * from Customer c where c.email = theEmail;  return null if not found
    //@RestResource(path = "find-customer-email")
    Customer findByEmail(String theEmail);
}
