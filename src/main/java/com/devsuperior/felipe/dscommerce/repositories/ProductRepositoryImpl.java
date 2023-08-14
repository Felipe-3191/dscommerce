package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class ProductRepositoryImpl implements ProductRepositoryCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void refresh(Product p) {
        em.refresh(p);
    }
}
