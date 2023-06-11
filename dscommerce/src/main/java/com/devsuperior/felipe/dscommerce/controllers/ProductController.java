package com.devsuperior.felipe.dscommerce.controllers;

import com.devsuperior.felipe.dscommerce.dto.ProductDTO;
import com.devsuperior.felipe.dscommerce.entities.Product;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import com.devsuperior.felipe.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }


    @PostMapping
    public ProductDTO insert (@RequestBody ProductDTO dto){
        ProductDTO response = service.insert(dto);
        return response;
    }

}
