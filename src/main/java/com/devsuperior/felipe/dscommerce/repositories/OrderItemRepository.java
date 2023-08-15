package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.entities.OrderItem;
import com.devsuperior.felipe.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository <OrderItem, OrderItemPK> {

}
