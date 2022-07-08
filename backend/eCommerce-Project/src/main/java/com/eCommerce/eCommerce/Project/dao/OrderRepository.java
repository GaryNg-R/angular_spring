package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    @RestResource(path = "by-customer-email")
    Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
    /*
    select * from orders
    left outer join cusomter
    on orders.cusotmer_id = customer.id
    where customer.email=:email



     */
}
