package com.devsuperior.felipe.componentes.services;

import com.devsuperior.felipe.componentes.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    //nao concordo em receber o order aqui, para mim poderia apenas receber um double com o valor já com desconto calculado
    public double shipment(Order order) {


        double valuewDiscount = order.getValueWDiscount();

        if (valuewDiscount < 100.00) {
            return 20.00;
        }

        if (valuewDiscount > 100.00 && valuewDiscount < 200.00) {
            return 12.00;
        }


        return 0.0;


    }
}
