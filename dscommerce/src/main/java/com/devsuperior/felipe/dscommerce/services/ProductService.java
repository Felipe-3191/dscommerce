package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.dto.ProductDTO;
import com.devsuperior.felipe.dscommerce.entities.Product;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        Page<ProductDTO> resultDTO = result.map(r -> new ProductDTO(r));
        return resultDTO;
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = fromDTO(dto);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    private Product fromDTO(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getImgUrl()
        );
    }

}
