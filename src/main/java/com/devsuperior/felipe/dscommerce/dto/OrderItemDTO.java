package com.devsuperior.felipe.dscommerce.dto;

import com.devsuperior.felipe.dscommerce.entities.OrderItem;
import jakarta.validation.constraints.Positive;

public class OrderItemDTO {

    private Long productId;
    private String name;

    @Positive
    private Double price;

    @Positive
    private Integer quantity;


    public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getProduct().getPrice();
        this.quantity = entity.getQuantity();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return price * quantity;
    }



}
