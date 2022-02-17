package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
