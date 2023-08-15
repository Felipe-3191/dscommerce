package com.devsuperior.felipe.dscommerce.dto;

import com.devsuperior.felipe.dscommerce.entities.Order;
import com.devsuperior.felipe.dscommerce.entities.OrderStatus;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    @Valid
    private List<OrderItemDTO> items = new ArrayList<>();


    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }


    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDTO(entity.getClient());
        this.items = entity.getItems().stream().map(i-> new OrderItemDTO(i)).collect(Collectors.toList());
        this.payment = entity.getPayment() == null ? null : new PaymentDTO(entity.getPayment());
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        return items.stream().mapToDouble(OrderItemDTO::getSubTotal).sum();
    }

}
