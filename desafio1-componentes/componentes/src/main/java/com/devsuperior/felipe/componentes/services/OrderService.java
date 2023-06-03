package com.devsuperior.felipe.componentes.services;

import com.devsuperior.felipe.componentes.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;


    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double valuewDiscount = order.getValueWDiscount();
        return valuewDiscount + shippingService.shipment(order);

    }


}
