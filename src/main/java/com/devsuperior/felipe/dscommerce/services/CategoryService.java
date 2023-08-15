package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.dto.CategoryDTO;
import com.devsuperior.felipe.dscommerce.dto.ProductDTO;
import com.devsuperior.felipe.dscommerce.dto.ProductMinDTO;
import com.devsuperior.felipe.dscommerce.entities.Category;
import com.devsuperior.felipe.dscommerce.entities.Product;
import com.devsuperior.felipe.dscommerce.repositories.CategoryRepository;
import com.devsuperior.felipe.dscommerce.repositories.ProductRepository;
import com.devsuperior.felipe.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.felipe.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;



    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){

        List<Category> result = repository.findAll();
        return  result.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }



}
