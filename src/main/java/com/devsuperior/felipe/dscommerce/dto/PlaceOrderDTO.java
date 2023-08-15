package com.devsuperior.felipe.dscommerce.dto;

import com.devsuperior.felipe.dscommerce.entities.Order;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceOrderDTO {
    @NotEmpty(message = "A lista precisa possuir ao menos um pedido")
    private List<OrderItemDTO> items = new ArrayList<>();

    public PlaceOrderDTO() {

    }
    public PlaceOrderDTO(Order entity){
        this.items = entity.getItems().stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }
}
