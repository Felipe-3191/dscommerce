package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.dto.OrderDTO;
import com.devsuperior.felipe.dscommerce.dto.PlaceOrderDTO;
import com.devsuperior.felipe.dscommerce.entities.*;
import com.devsuperior.felipe.dscommerce.repositories.OrderItemRepository;
import com.devsuperior.felipe.dscommerce.repositories.OrderRepository;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import com.devsuperior.felipe.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        //por estar dentro da mesma transação eu poderia buscar através do repository.findOrderById
        // e depois chamar o ordem.getItems tbm que não daria exceção
        Order order = repository.searchOrderByIdWithItems(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não Encontrado")
        );

    authService.validateSelfOrAdmin(order.getClient().getId());



        return new OrderDTO(order);
    }
        @Transactional
       public OrderDTO insert(PlaceOrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);
        dto.getItems().stream().forEach(orderItemDTO -> {
            Product product = productRepository.getReferenceById(orderItemDTO.getProductId());
            OrderItem orderItem = new OrderItem(order,product, orderItemDTO.getQuantity(), orderItemDTO.getPrice());
            order.addOrderItem(orderItem);

        } );

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
