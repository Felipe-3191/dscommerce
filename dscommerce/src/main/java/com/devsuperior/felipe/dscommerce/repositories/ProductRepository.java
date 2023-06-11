package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
