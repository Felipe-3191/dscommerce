package com.devsuperior.felipe.dscommerce.controllers;

import com.devsuperior.felipe.dscommerce.dto.ProductDTO;
import com.devsuperior.felipe.dscommerce.entities.Product;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import com.devsuperior.felipe.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

}
