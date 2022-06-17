package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.dto.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
