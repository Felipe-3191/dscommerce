package com.devsuperior.felipe.desafiocrud.services;

import com.devsuperior.felipe.desafiocrud.entities.Client;
import com.devsuperior.felipe.desafiocrud.entities.dto.ClientDTO;
import com.devsuperior.felipe.desafiocrud.repositories.ClientRepository;

import com.devsuperior.felipe.desafiocrud.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {


    private ClientRepository repository;
    private ModelMapper mapper;



    public ClientService(ClientRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
        //duas linhas abaixo feitas para evitar que o campo id fosse alterado em uma entidade managed do hibernate, acontecia erro no momento do atualizar
        TypeMap<ClientDTO, Client> propertyMapper = this.mapper.createTypeMap(ClientDTO.class, Client.class);
        propertyMapper.addMappings(map -> map.skip(Client::setId));
    }



    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
        return mapper.map(client, ClientDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(c -> mapper.map(c,ClientDTO.class));
    }

    @Transactional
    public ClientDTO save(ClientDTO dto) {
        Client client = this.mapper.map(dto, Client.class);
        client = repository.save(client);
        return this.mapper.map(client, ClientDTO.class);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        /* usando o mapper é gerado um erro de nível mais baixo, semelhante ao erro gerado
         com Constraint Violation no exemplo dado pelo professor, por isso realizei a checagem existsById
         para lançar manualmente a exceção
         */
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Recurso não Encontrado");
            Client client = repository.getReferenceById(id);
            this.mapper.map(dto, client);
            Client updatedClient = repository.save(client);
            return mapper.map(updatedClient, ClientDTO.class);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Recurso não Encontrado");
        repository.deleteById(id);
    }
}
