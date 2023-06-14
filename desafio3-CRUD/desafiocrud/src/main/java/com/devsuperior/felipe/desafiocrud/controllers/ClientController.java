package com.devsuperior.felipe.desafiocrud.controllers;

import com.devsuperior.felipe.desafiocrud.entities.Client;
import com.devsuperior.felipe.desafiocrud.entities.dto.ClientDTO;
import com.devsuperior.felipe.desafiocrud.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> clients = service.findAll(pageable);
        return ResponseEntity.ok().body(clients);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert (@Valid @RequestBody ClientDTO dto) {
        ClientDTO responseClient = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseClient.getId()).toUri();
        return ResponseEntity.created(uri).body(responseClient);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDTO> update (@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        ClientDTO responseClient = service.update(id, dto);
        return ResponseEntity.ok().body(responseClient);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
