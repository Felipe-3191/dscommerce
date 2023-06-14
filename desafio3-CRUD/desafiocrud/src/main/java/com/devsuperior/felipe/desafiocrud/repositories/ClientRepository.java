package com.devsuperior.felipe.desafiocrud.repositories;

import com.devsuperior.felipe.desafiocrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
}
