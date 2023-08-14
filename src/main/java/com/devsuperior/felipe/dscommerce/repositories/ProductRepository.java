package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.dto.ProductMinDTO;
import com.devsuperior.felipe.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select new com.devsuperior.felipe.dscommerce.dto.ProductMinDTO(p.id, p.name, p.price, p.imgUrl)" +
            " from Product p")
    public Page<ProductMinDTO> buscaRetornandoDTO(Pageable page);
}
