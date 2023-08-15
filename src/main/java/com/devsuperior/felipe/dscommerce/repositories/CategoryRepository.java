package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.dto.ProductMinDTO;
import com.devsuperior.felipe.dscommerce.entities.Category;
import com.devsuperior.felipe.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long>{


}
