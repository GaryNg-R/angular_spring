package com.eCommerce.eCommerce.Project.dao;

import com.eCommerce.eCommerce.Project.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

        Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
        Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
        //same as select * from product p where p.name like concat ('%', :name, '%')

}
