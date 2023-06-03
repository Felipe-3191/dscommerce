package com.devsuperior.felipe.componentes;

import com.devsuperior.felipe.componentes.entities.Order;
import com.devsuperior.felipe.componentes.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentesApplication implements CommandLineRunner {

    private OrderService orderService;

    public ComponentesApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    //não foi necessário mapear os services pois coloquei na pasta abaixo do pacote principal.
    public static void main(String[] args) {
        SpringApplication.run(ComponentesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Order> pedidos = new ArrayList<>();

        Order pedido1 = new Order(1034, 150.00, 20.0);
        Order pedido2 = new Order(2282, 800.00, 10.0);
        Order pedido3 = new Order(1309, 95.90, 0.0);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);


        pedidos.forEach(
                o -> {
                    System.out.println("Pedido código:" + o.getCode());
                    System.out.println("Valor Total: " + orderService.total(o));
                    System.out.println("======================================");
                }
        );


    }
}
