package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

    @Query("select o from Order o join fetch o.items where o.id = :id")
    public Optional<Order> searchOrderByIdWithItems(Long id);
}
