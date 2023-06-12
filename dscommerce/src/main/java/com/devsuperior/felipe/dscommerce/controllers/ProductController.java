package com.devsuperior.felipe.dscommerce.controllers;

import com.devsuperior.felipe.dscommerce.dto.ProductDTO;
import com.devsuperior.felipe.dscommerce.entities.Product;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import com.devsuperior.felipe.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> insert (@RequestBody ProductDTO dto){
        ProductDTO response = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable Long id, @RequestBody ProductDTO dto){
        ProductDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); alternativamente também funcionaria assim
        return ResponseEntity.noContent().build();
    }

}
