package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.dto.OrderDTO;
import com.devsuperior.felipe.dscommerce.entities.Order;
import com.devsuperior.felipe.dscommerce.repositories.OrderRepository;
import com.devsuperior.felipe.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;


    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        //por estar dentro da mesma transação eu poderia buscar através do repository.findOrderById
        // e depois chamar o ordem.getItems tbm que não daria exceção
        Order order = repository.searchOrderByIdWithItems(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não Encontrado")
        );

        return new OrderDTO(order);
    }
}
